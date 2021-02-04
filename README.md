# mywave-calculator

## Prerequisite

maven 3.6.2 Jdk 14

---

## How to use?
Assumed the input is provided as program arguments when executing program
so it can be run from any IDE or command line
### Run program

if maven and java14 are available in machine
<blockquote>
mvn compile exec:java -Dexec.mainClass=ai.mywave.App -Dexec.args="2 + 3"
</blockquote>
otherwise (using docker)  
<blockquote>
docker run -v "$PWD:/home" -w /home -it maven:3.6.3-adoptopenjdk-14 bash  

mvn compile exec:java -Dexec.mainClass=ai.mywave.App -Dexec.args="2 + 3"
</blockquote>

### Run test
<blockquote>
mvn clean verify
</blockquote>

#### Coverage report
Code coverage report is available in
<blockquote>
target/site/jacoco/index.html
</blockquote>

---

## Quality

### Findbugs

`mvn findbugs:gui`

### checkstyle

`mvn checkstyle::check`

### pmd

`mvn pmd::pmd`

---

### Practices

Had pre-commit git hook which run `mvn clean verify` before pushing so every push ensure better quality code   
Used `jacoco` code coverage tool to fail build when code coverage is compromised
