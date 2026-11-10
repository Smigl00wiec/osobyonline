# OnlineOsoby

Plugin na Paper 1.21.4 dodajacy placeholder `%online_osoby%` (PlaceholderAPI),
ktory pokazuje liczbe graczy w aktualnym trybie (grupie swiatow z `config.yml`).
Dziala m.in. w FancyHolograms.

## Wymagania
- Paper 1.21.4, Java 21
- PlaceholderAPI

## Budowanie
```
mvn clean package
```
Gotowy plik: `target/OnlineOsoby-1.0.jar`

## Uzycie
```
/hologram edit <nazwa> addline Online: %online_osoby%
```
