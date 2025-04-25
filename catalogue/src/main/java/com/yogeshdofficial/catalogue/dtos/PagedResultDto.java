package com.yogeshdofficial.catalogue.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PagedResultDto<T> {
  List<T> data;
  long totalElements;
  int pageNumber;
  int totalPages;
  boolean isFirst;
  boolean isLast;
  boolean hasNext;
  boolean hasPrevious;
}
