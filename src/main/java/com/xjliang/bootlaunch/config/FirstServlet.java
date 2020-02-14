package com.xjliang.bootlaunch.config;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@WebServlet(name = "firstServlet", urlPatterns = "/firstServlet") //标记为servlet，以便启动器扫描。
@Slf4j
public class FirstServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        log.info("servlet ");
        resp.getWriter().append("firstServlet");
    }
}
