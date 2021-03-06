package com.studyolle.modules.account;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.transaction.annotation.Transactional;


@Transactional(readOnly = true) //조금이라도 성능의 이점을 가져오기 위해 read only true
public interface AccountRepository extends JpaRepository<Account, Long> , QuerydslPredicateExecutor<Account> {
    boolean existsByEmail(String email);

    boolean existsByNickname(String nickname);


    Account findByEmail(String s);

    Account findByNickname(String emailOrNickname);


    @EntityGraph(attributePaths = {"tags", "zones"})
    Account findAccountWithTagsAndZonesById(Long id);
}
