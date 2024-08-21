package com.bit.springboard.dto;
// Lombok에서 제공하는 어느테이션으로 Setter, Getter, toString 등의 메소드를 생성할 수 있다

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MemberDto {
    private int id;
    private String username;
    private String password;
    private String email;
    private String nickname;
    private String tel;
    private String role;

}
