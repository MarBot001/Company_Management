package org.beadando.company.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Company {
    private String id = UUID.randomUUID().toString();
    private String name;
    private String location;
}
