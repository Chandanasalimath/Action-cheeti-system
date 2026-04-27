package com.actioncheeti.actioncheeti;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cheeti-member")
@CrossOrigin
public class CheetiMemberController {

    @Autowired
    private CheetiService service;

    // ADD MEMBER
    @PostMapping
    public CheetiMember addMember(@RequestBody CheetiMember member) {
        return service.addMember(member);
    }

    // PAY
    @PutMapping("/pay/{id}")
    public CheetiMember pay(@PathVariable Long id) {
        return service.pay(id);
    }

    // BID
    @PutMapping("/bid/{id}")
    public CheetiMember bid(@PathVariable Long id,
                           @RequestParam double amount) {
        return service.placeBid(id, amount);
    }

    // WINNER
    @GetMapping("/winner/{cheetiId}")
    public String winner(@PathVariable Long cheetiId) {
        return service.selectWinner(cheetiId);
    }

    // 🔥 DASHBOARD
    @GetMapping("/dashboard")
    public String dashboard() {
        return service.getDashboard();
    }
}