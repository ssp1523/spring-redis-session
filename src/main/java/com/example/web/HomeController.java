/*
 * Copyright 2014-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.web;

import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @author jitendra on 5/3/16.
 */
@RestController
public class HomeController {

    @PostMapping("/value")
    public String setValue(@RequestParam(name = "key", required = false) String key,
                           @RequestParam(name = "value", required = false) String value,
                           HttpSession session) {
        if (!ObjectUtils.isEmpty(key) && !ObjectUtils.isEmpty(value)) {
            session.setAttribute(key, value);
        }
        return "home";
    }

    @GetMapping("/value/{key}")
    public Object getValue(@PathVariable String key, HttpSession session) {
        return session.getAttribute(key);
    }
}
