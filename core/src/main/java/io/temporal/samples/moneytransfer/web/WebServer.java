/*
 *  Copyright (c) 2020 Temporal Technologies, Inc. All Rights Reserved
 *
 *  Copyright 2012-2016 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 *  Modifications copyright (C) 2017 Uber Technologies, Inc.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License"). You may not
 *  use this file except in compliance with the License. A copy of the License is
 *  located at
 *
 *  http://aws.amazon.com/apache2.0
 *
 *  or in the "license" file accompanying this file. This file is distributed on
 *  an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 *  express or implied. See the License for the specific language governing
 *  permissions and limitations under the License.
 */

package io.temporal.samples.moneytransfer.web;

import io.javalin.Javalin;

public class WebServer {
  public static void main(String[] args) {
    Javalin app =
        Javalin.create(
            config -> {
              config.staticFiles.add(
                  staticFiles -> {
                    staticFiles.hostedPath = "/";
                    staticFiles.directory = "svelte_ui/build";
                    // are located
                  });
            });

    app.get(
        "/serverinfo",
        ctx -> {
          // some code
          ctx.json(ServerInfo.getServerInfo());
        });
    app.get("/test", ctx -> ctx.result("Hello Javalin!"));

    app.start(7070);
  }
}