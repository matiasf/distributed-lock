/*
 * MIT License
 *
 * Copyright (c) 2018 Alen Turkovic
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.github.alturkovic.lock.jdbc.configuration;

import com.github.alturkovic.lock.Lock;
import com.github.alturkovic.lock.jdbc.impl.SimpleJdbcLock;
import com.github.alturkovic.lock.jdbc.service.JdbcLockSingleKeyService;
import com.github.alturkovic.lock.jdbc.service.SimpleJdbcLockSingleKeyService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class JdbcDistributedLockConfiguration {

  @Bean
  public Lock simpleMongoLock(final JdbcLockSingleKeyService jdbcLockSingleKeyService) {
    return new SimpleJdbcLock(jdbcLockSingleKeyService);
  }

  @Bean
  public JdbcLockSingleKeyService jdbcLockSingleKeyService(final JdbcTemplate jdbcTemplate) {
    return new SimpleJdbcLockSingleKeyService(jdbcTemplate);
  }
}
