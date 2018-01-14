package com.pw.spockLearn

import spock.lang.Shared
import spock.lang.Specification

/**
 * Created by piotrek on 2018-01-14.
 */

// Cykl życia testów spock
// Test w spock to tak naprawdę również specyfikacja
class LifecycleSpockTest extends Specification{

    // Poniżej pola jakie są zdefiniowane w naszej specyfikacji

    // @Shared oznacza że pole jest współdzielone przez wszystkie testy danej specyfikacji
    //  - jest praktycznie tożsame z tym jakbyśmy użyli słówka static przed polem
    @Shared
    StringWriter writer

    static StringWriter writer2

    //jeżeli pole jest bez żadnego modyfikatora jest to tylko pole tej klasy i tak samo jak w testUnit, nowa instancja
    // klasy testowej jest tworzona per każde wywołanie testu i to Person będzie gotowe, czyste na każde wywołanie naszego testu
    Person person

    // metoda setupSpec pozwala na setupowanie specyfikacji czyli wykonanie czegoś na samym początku całego zestawu testów
    // tutaj ważna jest nazwa, metoda ta musi nazywać się "setupSpec()"
    def setupSpec(){
        println "In setup spec"
        writer = new StringWriter()
    }

    // metoda setup() pozwala na setupowanie okreśolnych rzeczy przed wywołaniem każdego testu, tutaj również najważniejsza jest nazwa
    def setup(){
        println "In setup"
        person = new Person(firstName: "Bob", lastName: "Smith", age: 21)
    }
}
