package com.studyolle.modules.account;

import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.studyolle.modules.tag.Tag;
import com.studyolle.modules.zone.Zone;

import java.util.Set;

public class AccountPredicates {

    public static Predicate findByTagsAndZones(Set<Tag> tags, Set<Zone> zones) {
        QAccount account = QAccount.account;
        BooleanExpression and = account.zones.any().in(zones).and(account.tags.any().in(tags));
        return account.zones.any().in(zones).and(account.tags.any().in(tags));
    }
}
