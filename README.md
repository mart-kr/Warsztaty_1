<h2>CodersLab - Warsztaty 1: podstawy programowania w Javie</h2>

Celem warsztatów było utworzenie 5 krótkich aplikacji konsolowych:

1. Gra w zgadywanie liczb
2. Symulator LOTTO
3. Gra w zgadywanie liczb 2
4. Kostka do gry
5. Wyszukiwarka najpopularniejszych słów

<h4>Gra w zgadywanie liczb</h4>
Komputer losuje liczbę z przedziału 1-100, a następnie użytkownik próbuje odgadnąć jaka liczba została wylowowana. Po każdej próbie program informuje użytkownika czy podana liczba jest za mała czy za duża, aż do czasu, kiedy użytkownik odgadnie liczbę.

<h4>Symulator LOTTO</h4>
Komputer losuje 6 liczb z zakresu 1-49, następnie użytkownik podaje 6 liczb. Program weryfikuje czy wprowadzane wartości są liczbami z zakresu 1-49 oraz czy użytkownik nie podał dwa razy tej samej liczby. Na koniec program wyświetla informację o wyniku gry.

<h4>Gra w zgadywanie liczb 2</h4>
Użytkownik ma za zadanie pomyśleć o liczbie z zakresu 1-1000, a następnie program będzie zgadywał liczbę. Użytkownik ma za zadanie informować program po każdej próbie czy podana liczba jest za mała lub za duża oraz poinformować kiedy komputer odgadnie wybraną liczbę. Liczba zostanie odgadnięta w maksymalnie 10 ruchach.

<h4>Kostka do gry</h4>
Program ma za zadanie symulować rzuty kostką o zadanych parametrach. Użytkownik podaje łańcuch znaków w zamieszczonym poniżej schemacie, program rozpoznaje parametry i symuluje rzut zwracając wylosowaną liczbę.
<br>
Kod takiej kostki wygląda następująco:

xDy+z<br>
gdzie:

y – rodzaj kostek, których należy użyć (np. D6, D10),<br>
x – liczba rzutów kośćmi (jeśli rzucamy raz, ten parametr jest pomijalny),<br>
z – (opcjonalnie) liczba, którą należy dodać (lub odjąć) do wyniku rzutów.

<h4>Wyszukiwarka najpopularniejszych słów</h4>
Program wykorzystuje bibliotekę jsoup. Zadaniem programu jest stworzenie listy 10 najpopularniejszych słów pojawiających się na portalach informacyjnych. Program pobiera tytuły z kilku serwisów internetowych, następnie zapisuje wszystkie słowa do pliku. W kolejnym kroku z listy zostają usunięte słowa o gługości do 3 znaków. W następnych krokach program zlicza wystąpienia każdego słowa, szereguje słowa w zależności od liczby wystąpień i zwraca listę 10 słów o najwyższej liczbie wystąpień.
