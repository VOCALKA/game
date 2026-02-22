# Pavla a Létající Boty
 Přehled hry

Pavla a Létající Boty je textová adventura, kde hrajete za stařenku Pavlu, která po 99 dnech na moři konečně dorazila na záhadný ostrov uprostřed Tichého oceánu.
Vaším úkolem je prozkoumat ostrov, pomoci tajemným a zakletým postavám, sbírat předměty a nakonec získat legendární létající boty.

Hra kombinuje průzkum, logické úkoly, interakci s NPC a pozorné naslouchání prostředí.

### Autor
GitHub: [VOCALKA](https://github.com/VOCALKA)

## Instalace
**Požadavky**
- Java 23 nebo novější
- IntelliJ IDEA (Community nebo Ultimate)
- Git

## Kroky

1. **Stáhněte projekt**

```bash
   cd C:\Users\YourUsername\Desktop
   ```
```bash
   git clone https://github.com/VOCALKA/game
   ```
2. **Otevřete projekt v IntelliJ IDEA**

- File → Open → vyberte složku projektu

3. **Build JAR souboru**

 - `File → `Project Structure → `Artifacts` → + → `JAR → `From modules with dependencies
 - Hlavní třída: main.Main
 - Apply → Build → Build Artifacts → Build

4. **Spuštění hry**
- Otevřete příkazový řádek
- Přejděte do složky

```bash
   cd path\to\game\out\artifacts\game_jar
```
- Spusťte hru:

```bash
java -jar game.jar
   ```
## Jak hrát
Hlavní příkazy:
- mluv <NPC> : Zahájí rozhovor s postavou
- odpovez <volba> : Odpověď během dialogu
- jdi <sever/jih/vychod/zapad> : Pohyb mezi lokacemi
- seber <předmět> : Přidá předmět do inventáře
- pouzij <předmět> : Použije předmět na lokaci nebo postavu
- inventar : Zobrazení inventáře
- prohledej : Vypíše objekty a postavy v lokaci
- naslouchej : Zachytí zvuky prostředí, klíčové pro úkol Bludného stromu
- ukoly : Zobrazení aktuálních úkolů
- detail <úkol> : Detailní informace o konkrétním úkolu
- pomoc : Přehled všech příkazů
- napoveda <úkol> : Dodatečná rada k úkolu
- konec : Ukončení hry

## Cíl hry
1. Pomoz Pavle projít ostrovem a splnit úkoly klíčových postav.
2. Pomoz Pavle projít ostrovem a splnit úkoly klíčových postav.
- Prázdná lahvička → Laguna → Naplněná lahvička → Balvadr
- Naslouchání zpěvu ptáků → Bludný strom
- Dřevo → Ztroskotanec → Světlo
3. použij světlo v mlze, aby se objevil Pán ostrova a položil tři otázky o počtech stromů, větví a kamenů.
4. Pokud odpovíš správně, Pavla získá létající boty a hra dosáhne vítězného konce.

## Lokace

- Pláž – výchozí místo po ztroskotání lodi
- Útes – obsahuje prázdnou lahvičku a jeden ze zpěvů ptáků
- Jeskyně – Balvadr čeká na odměnění pomocí lagunové vody
- Tábor – Ztroskotanec zadává úkol opravy lodi
- Laguna – magická voda pro kletbu Balvadra
- Les – Bludný strom a druhý zpěv ptáků
- Mlha – Pán ostrova, poslední výzva
- Studna – místo, kde Pavla získá létající boty
- Lokace X – tiché místo, poslední zpěv ptáků

## Postavy

- Pavla – hlavní hratelná postava
- Pán ostrova – poslední zkouška pozornosti
- Bludný strom – orientační úkol naslouchání ptáků
- Balvadr – zakletý balvan, potřebuje magickou vodu
- Ztroskotanec – zadává úkol opravy lodě

## Předměty

- Prázdná lahvička : K nabírání vody z laguny
- Naplněná lahvička : Používá se k oslabení kletby Balvadra
- Dřevo : K opravě lodě Ztroskotance
- Světlo : Umožní setkání s Pánem ostrova v mlze
- Létající boty : Odměna za dokončení hry, umožňují volné létání

## Inventář pojme maximálně 2 předměty současně.

## Herní mechaniky

- Pohyb: jdi <směr>
- Dialog: mluv <NPC>, odpovez <volba>
- Sebrání předmětu: seber <předmět>, prohledej
- Použití předmětu: pouzij <předmět>, inventar
- Naslouchat: naslouchej pro získání důležitých informací
- Úkoly: ukoly, detail <úkol>
- Nápověda: napoveda <úkol>
- Konec: konec

```
Pavla-a-Letajici-Boty/
├── src/
│   ├── main/         # Inicializace hry a hlavní smyčka
│   ├── characters/   # Player a NPC
│   ├── commands/     # Všechny příkazy
│   ├── items/        # Předměty a inventář
│   ├── quest/        # Ukoly
│   └── locations/    # Lokace ostrova
├── resources/
│   ├── gameData.json  # NPC, předměty, lokace, úkoly
└── lib/
```

## Použité knihovny
Gson v2.13.1 – načítání dat z gameData.json (NPC, předměty, lokace, úkoly)
