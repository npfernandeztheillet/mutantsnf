# Mutants by NF

## CI status
[![Build Status](https://travis-ci.org/npfernandeztheillet/mutantsnf.svg?branch=master)](https://travis-ci.org/npfernandeztheillet/mutantsnf)
## Coverage status
[![Coverage Status](https://coveralls.io/repos/github/npfernandeztheillet/mutantsnf/badge.svg?branch=master)](https://coveralls.io/github/npfernandeztheillet/mutantsnf?branch=master)

## API Usage

`App URL`
 + https://mutantsnf.herokuapp.com/mutant

`Usage` 
  
  + For POST requests (with a body): `Content-Type: application/json`


`POST /mutant`
  + No Mutant -> Body: `{"dna":["ATGCGA","CAGTGC","TTATTT","AGACGG","GCGTCA","TCACTG"]}`
  + Mutant -> Body: `{"dna":["ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"]}`

`Curl Commands`
+ curl -i -H "Content-type:application/json" https://mutantsnf.herokuapp.com/mutant -d '{"dna":["ATGCGA","CAGTGC","TTATTT","AGACGG","GCGTCA","TCACTG"]}'
+ curl -i -H "Content-type:application/json" https://mutantsnf.herokuapp.com/mutant -d '{"dna":["ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"]}'


## Documentation
+ [JDoc](https://npfernandeztheillet.github.io/mutantsnf/jdoc/overview-summary.html)
+ [Sequence diagram](/docs/pdf/sequence.pdf)
+ [Architecture diagram](/docs/pdf/architecture.pdf)


## Built With

* [SpringBoot](https://spring.io/projects/spring-boot)
* [Junit](https://junit.org/junit5/) Test Suite
* [Intellij](https://www.jetbrains.com/idea/) IDE
* [MySql](https://www.mysql.com/) DBMS 
* [Maven](https://maven.apache.org/) - Dependency management
* [ECache](https://rometools.github.io/rome/) -  LRU cache
* [Heroku](https://www.heroku.com/) - Cloud application Platform
* [Cloud Google](https://cloud.google.com/) - Cloud application Platform (used to the database hosting)
* [Jacoco](https://www.eclemma.org/jacoco/) - Code coverage library
* [Travis-CI](https://www.eclemma.org/jacoco/) - Continuos Integration
* [REST Assured](http://rest-assured.io/) - Test Rest API
* [Coveralls](http://coveralls.io/) - Test Coverage History & Stadistics

## Tools Links 

+ Travis:
https://travis-ci.org/npfernandeztheillet/mutantsnf

+ Heroku:
https://dashboard.heroku.com/apps/mutantsnf

+ Coveralls:
https://coveralls.io/github/npfernandeztheillet/mutantsnf






