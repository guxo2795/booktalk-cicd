package com.example.booktalk.domain.front.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FrontAdminTradeController {

    @GetMapping("api/v1/admin/trades/list")
    public String adminTradesPage() {
        return "tradeList";
    }
}