# mywave-calculator

## Quality

### Findbugs

`mvn findbugs:gui`

### checkstyle

`mvn checkstyle::check`

### pmd

`mvn pmd::pmd`

### Practices

Had pre-commit git hook which run `mvn clean verify` before pushing so every push ensure better quality code   
Used `jacoco` code coverage tool to fail build when there is any quality issue
