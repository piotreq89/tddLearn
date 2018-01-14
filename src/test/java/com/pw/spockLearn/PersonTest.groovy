package com.pw.spockLearn

import com.pw.spockLearn.Person
import spock.lang.Specification
//import

/**
 * Created by piotrek on 2018-01-14.
 */


// W spock wsyzstkie klasy są tak naprawde specyfikacjami i muszą rozszeżać klasę Specification
class PersonTest extends Specification{

    // Metody w spock są najczęściej zapsywane jako stringi, jest to feature groovy i dzięki temu jest większa czytelność
    def "should set first name from construktor"(){

        // w bloku when definiujemy co mamy odpalić, co jest przedmiotem testu
        when: "person with set first name"
            Person person = new Person(firstName: "Bob")

        // w bloku then definiujemy asercję
        //      - tutaj muci być coś co ewalułuje się do boolean
        //      - nie piszemy żadnych assertów
        then: "person has first name"
            person.firstName == "Bob"

    }

    def "should set first name from construktor2"(){
        // Można dodawać opisy bloków
        when: "person with set first name"
            Person person = new Person(firstName: "Bob")
        then: "person has first name"
            person.firstName == "Bob"
    }

    def "should set first name from setter"(){
        // W bloku given wywoływane są operacje na początku testu które nie są bezpośrednio związane z testem, taki
        // setup naszych danych
        given:
            Person person = new Person(firstName: "Bob")
        when: "person with set first name"
            person.firstName = 'Tom'
        then: "person has first name"
            person.firstName == "Tom"
    }

    def "should set person data from constructor"(){
        when:
            Person person = new Person("Bob", "Smith", 15)
        then:
            person.firstName == "Bob"
            person.lastName == "Smith"
            person.age == 15
    }

    def "should set person data from constructor2"(){
        when:
            Person person = new Person("Bob", "Smith", 15)
        then:
            verifyAll{
                person.firstName == 'Bob'
                person.lastName == 'Smith'
                person.age == 15
            }
    }

    def "should set first name from constructor and change with setter"(){
        when:
            Person person = new Person(firstName: "Bob")
        then:
            person.firstName == "Bob"
        when:
            person.firstName = "Tom"
        then:
            person.firstName == "Tom"
    }

    def "should set first name and lat name"(){
        when:
            Person person = new Person(firstName: "Bob", lastName: "Smith")
        then:
            person.firstName == "Bob"

        //blok and tylko graficznie różnicuje nam zbiór jakiś walidacji czy dowolnych rzeczy, można go używać do każdego
        // bloku, jak jest położony pod blokiem to jest on jego kontynuacją, można też dodać dodatkowy opis tego bloku
        and:
            person.lastName == "Smith"
    }

    def "should compare person with equals"(){
        // w bloku expect piszemy cała asercję, np tak jak poniżej nie ma sensu tworzyć w boloku when dwóch osób, porównywać
        // ich do siebie i zwracać boolean który będzie w bloku then sprawdzany czy jest true
        // pewnie można dodać opisy ale nic o tym nie mówił
        expect:
            new Person("Bob", "Smith", 15) == new Person("Bob", "Smith", 15)
    }
}












