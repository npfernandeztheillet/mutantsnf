# Mutants by NF

[![Build Status](https://travis-ci.org/npfernandeztheillet/mutantsnf.svg?branch=master)](https://travis-ci.org/npfernandeztheillet/mutantsnf)

[![Coverage Status](https://coveralls.io/repos/github/npfernandeztheillet/mutantsnf/badge.svg?branch=master)](https://coveralls.io/github/npfernandeztheillet/mutantsnf?branch=master)

## API Documentation

`URL:`
 + https://mutantsnf.herokuapp.com/mutant
 
`Headers:`
  + For POST requests (with a body): `Content-Type: application/json`


`POST /mutants`
  + No Mutant -> Body: `{ "dna":["ATGCGA","CAGTGC","TTATTT","AGACGG","GCGTCA","TCACTG"] }`
  + Mutant -> Body: `{"dna":["ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"]}`


Travis:
https://travis-ci.org/npfernandeztheillet/mutantsnf

Heroku:
https://dashboard.heroku.com/apps/mutantsnf

CodeCov:
https://codecov.io/gh/npfernandeztheillet/mutantsnf






