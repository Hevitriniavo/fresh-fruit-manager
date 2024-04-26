package com.tantely.freshfruitmanager.dtos;

import java.util.List;

public record Paginate <T> (
      Integer totalPages,
      Integer nextPage,
      Integer previousPage,
      List<T> data
){}
