package com.mirjalolcode.expensetracker.service


import com.mirjalolcode.expensetracker.repository.UserRepository
import spock.lang.Specification

class UserServiceImplTest extends Specification {

    def repository = GroovyMock(UserRepository)

    def "should throw exception when user provided not well formatted email"() {
        given:
            def sut = new UserServiceImpl(repository)
        when:
            sut.registerUser("firstName", "lastName", "wrongEmail", "pass")
        then:
            thrown(IllegalArgumentException.class)
    }

}
