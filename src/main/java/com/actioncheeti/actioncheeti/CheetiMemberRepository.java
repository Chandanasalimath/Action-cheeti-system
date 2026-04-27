package com.actioncheeti.actioncheeti;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CheetiMemberRepository extends JpaRepository<CheetiMember, Long> {

    List<CheetiMember> findByCheetiIdAndHasPaid(Long cheetiId, boolean hasPaid);
}