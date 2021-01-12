% definicion del grafo

arco(s ,c, 1).
arco(s ,g, 4).
arco(c, f, 8).
arco(c, i, 1).
arco(g, i, 1).
arco(g, d, 13).
arco(i, f, 5).
arco(f, e, 2).
arco(i, e, 2).
arco(d, j, 7).
arco(j, e, 1).

% path:
%     calcula el costo de los caminos desde X hasta Y.

path(X, Y, P):- arco(X,Y,P).

path(X, Y, Peso):-
    arco(X, Z, Weight),
    path(Z, Y, W),
    Peso is Weight+W.

% all_path:
%     almacena el costo de todos los caminos desde X hasta Y.

all_path(X, Y, L):-
    all_path(X, Y, [], L),!.

all_path(X, Y, Aux1, L):-
    path(X, Y, P),
    \+ member(P, Aux1),
    append([P], Aux1, Aux2),
    all_path(X, Y, Aux2, L).

all_path(_ , _, L, L).

% live_or_die:
%     calcula la cantidad de veces en que Giusseppe muere o vive.

live_or_die(HP, Vive, Muere):-
    all_path(s, e, L),
    live_or_die(HP, Vive, Muere, L),!.

live_or_die(HP, Vive, Muere, [Peso|L]):-
    HP > Peso,
    live_or_die(HP, V, Muere, L),
    Vive is V+1;
    HP =< Peso,
    live_or_die(HP, Vive, M, L),
    Muere is M+1.

live_or_die(_, 0, 0, []).
