package com.jquezada.blazetraineeproject.web.app.resources.v1;

import com.jquezada.blazetraineeproject.web.app.auth.jwt.JwtUtils;
import com.jquezada.blazetraineeproject.web.app.auth.service.UserDetailsImpl;
import com.jquezada.blazetraineeproject.web.app.domain.entity.ERole;
import com.jquezada.blazetraineeproject.web.app.domain.entity.Employee;
import com.jquezada.blazetraineeproject.web.app.domain.entity.Role;
import com.jquezada.blazetraineeproject.web.app.repositories.EmployeeRepository;
import com.jquezada.blazetraineeproject.web.app.repositories.RoleRepository;
import com.jquezada.blazetraineeproject.web.app.resources.request.auth.LoginRequest;
import com.jquezada.blazetraineeproject.web.app.resources.request.auth.SignupRequest;
import com.jquezada.blazetraineeproject.web.app.resources.response.auth.JwtResponse;
import com.jquezada.blazetraineeproject.web.app.resources.response.auth.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("api/v1/auth")
public class AuthResource {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    PasswordEncoder encoder;
    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());
        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                userDetails.getEmail(),
                roles));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
        if (employeeRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }
        if (employeeRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }
        // Create new employee's account
        Employee employee = new Employee(signUpRequest.getFirstName(),
                signUpRequest.getLastname(),
                signUpRequest.getEmail(),
                signUpRequest.getUsername(),
                encoder.encode(signUpRequest.getPassword()),
                signUpRequest.getCompanyId(),
                signUpRequest.getShops());
        String role = signUpRequest.getRole();
        Role roleDB = null;
        if (role == null) {
            roleDB = roleRepository.findByAuthority(ERole.ROLE_EMPLOYEE)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        } else {
            switch (role) {
                case "admin":
                    roleDB = roleRepository.findByAuthority(ERole.ROLE_ADMIN)
                            .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                    break;
                case "mod":
                    roleDB = roleRepository.findByAuthority(ERole.ROLE_MODERATOR)
                            .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                    break;
                default:
                    roleDB = roleRepository.findByAuthority(ERole.ROLE_EMPLOYEE)
                            .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            }
        }
        employee.setRole(roleDB);
        employeeRepository.save(employee);
        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }
}
