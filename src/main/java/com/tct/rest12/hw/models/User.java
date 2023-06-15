package com.tct.rest12.hw.models;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
public class User {
    @NonNull
    private Integer id;
    private String name;
    private String email;
    /*
    2. Create a  REST API that gets an object User(id,name,email)
    and return this info as a single string.
     */
}
