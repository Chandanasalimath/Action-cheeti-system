package com.actioncheeti.actioncheeti;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheetiService {

    @Autowired
    private CheetiMemberRepository repository;

    private final double TOTAL_AMOUNT = 150000;
    private final double AGENT_FEE = 2000;

    // ADD MEMBER
    public CheetiMember addMember(CheetiMember member) {
        return repository.save(member);
    }

    // PAY
    public CheetiMember pay(Long id) {
        CheetiMember m = repository.findById(id).orElseThrow();
        m.setHasPaid(true);
        return repository.save(m);
    }

    // BID
    public CheetiMember placeBid(Long id, double amount) {
        CheetiMember m = repository.findById(id).orElseThrow();
        m.setBidAmount(amount);
        return repository.save(m);
    }

    // WINNER
    public String selectWinner(Long cheetiId) {

        List<CheetiMember> members =
                repository.findByCheetiIdAndHasPaid(cheetiId, true);

        CheetiMember winner = null;
        double highestBid = 0;

        for (CheetiMember m : members) {
            if (!m.isHasWon() && m.getBidAmount() > highestBid) {
                highestBid = m.getBidAmount();
                winner = m;
            }
        }

        if (winner == null) return "No eligible winner";

        double givenAmount = TOTAL_AMOUNT - highestBid;

        winner.setHasWon(true);
        repository.save(winner);

        return "🏆 Winner: User " + winner.getUserId() +
                " | Given Amount: " + givenAmount;
    }

    // 🔥 DASHBOARD (NEW)
    public String getDashboard() {

        List<CheetiMember> members = repository.findAll();

        long totalMembers = members.size();

        long paidMembers = members.stream()
                .filter(CheetiMember::isHasPaid)
                .count();

        double totalBids = members.stream()
                .mapToDouble(CheetiMember::getBidAmount)
                .sum();

        long winners = members.stream()
                .filter(CheetiMember::isHasWon)
                .count();

        return "📊 Total Members: " + totalMembers +
                "\n💰 Paid Members: " + paidMembers +
                "\n📈 Total Bid Amount: " + totalBids +
                "\n🏆 Winners: " + winners;
    }

	public CheetiMemberRepository getRepository() {
		return repository;
	}

	public void setRepository(CheetiMemberRepository repository) {
		this.repository = repository;
	}

	public double getTOTAL_AMOUNT() {
		return TOTAL_AMOUNT;
	}

	public double getAGENT_FEE() {
		return AGENT_FEE;
	}
}