package com.example.case_study.repository.user;

import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;

public interface UserRepository extends JpaAttributeConverter<User,> {
}
