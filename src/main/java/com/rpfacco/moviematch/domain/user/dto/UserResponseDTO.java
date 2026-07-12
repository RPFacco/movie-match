package com.rpfacco.moviematch.domain.user.dto;

import java.util.UUID;

public record UserResponseDTO(
   UUID id,
   String name,
   String email
) {}
