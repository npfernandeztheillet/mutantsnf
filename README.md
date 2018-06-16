# Mutants by NF

[![Build Status](https://travis-ci.org/npfernandeztheillet/mutantsnf.svg?branch=master)](https://travis-ci.org/npfernandeztheillet/mutantsnf)

[![Coverage Status](https://coveralls.io/repos/github/npfernandeztheillet/mutantsnf/badge.svg?branch=master)](https://coveralls.io/github/npfernandeztheillet/mutantsnf?branch=master)

## API Usage

`App URL`
 + https://mutantsnf.herokuapp.com/mutant

`Usage` 
  
  + For POST requests (with a body): `Content-Type: application/json`


`POST /mutants`
  + No Mutant -> Body: `{"dna":["ATGCGA","CAGTGC","TTATTT","AGACGG","GCGTCA","TCACTG"]}`
  + Mutant -> Body: `{"dna":["ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"]}`

## Documentation
+ [JDoc](/doc/jdoc/index.html)
+ [Sequence diagram](/docs/pdf/sequence.pdf)
+ [Architecture diagram](/docs/pdf/architecture.pdf)


## Built With

* [SpringBoot](https://spring.io/projects/spring-boot)
* [Junit](https://junit.org/junit5/) Test Suite
* [MySql](https://www.mysql.com/) DBMS 
* [Maven](https://maven.apache.org/) - Dependency management
* [ECache](https://rometools.github.io/rome/) -  LRU cache
* [Heroku](https://www.heroku.com/) - Cloud application Platform
* [Jacoco](https://www.eclemma.org/jacoco/) - Code coverage library
* [Tracis-CI](https://www.eclemma.org/jacoco/) - Continuos Integration
* [REST Assured](http://rest-assured.io/) - Test Rest API


Travis:
https://travis-ci.org/npfernandeztheillet/mutantsnf

Heroku:
https://dashboard.heroku.com/apps/mutantsnf

CodeCov:
https://codecov.io/gh/npfernandeztheillet/mutantsnf






