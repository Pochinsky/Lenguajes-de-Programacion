% team:
%     crea un equipo de N integrantes y guarda el resto de integrantes
%     en Resto_integrantes.

team(N, [I|Integrantes], Nuevo_equipo, Resto_integrantes):-
    append([I], [], Aux),
    X is N-1,
    X = 0,
    append(Aux, [], Nuevo_equipo),
    append(Integrantes, [], Resto_integrantes);
    append([I], [], Aux),
    X is N-1,
    team(X, Integrantes, Nuevo_equipo, Resto_integrantes, Aux).

team(N,[I|Integrantes], Nuevo_equipo, Resto_integrantes, Equipo):-
    append(Equipo, [I], Aux),
    X is N-1,
    X = 0,
    append(Aux, [], Nuevo_equipo),
    append(Integrantes, [], Resto_integrantes);
    append(Equipo, [I], Aux),
    X is N-1,
    team(X, Integrantes, Nuevo_equipo, Resto_integrantes, Aux).

% make_teams:
%     crea los teams necesarios con la cantidad de integrantes
%     correspondientes.

make_teams([N|Numeros], Integrantes, Teams):-
    team(N, Integrantes, Nuevo_equipo, Resto_integrantes),
    make_teams(Numeros, Resto_integrantes, Teams, [Nuevo_equipo]);
    team(N, Integrantes, Nuevo_equipo, Resto_integrantes),
    append([Nuevo_equipo], [], Teams).

make_teams([N|Numeros], Integrantes, Teams, Teams_listos):-
    team(N, Integrantes, Nuevo_equipo, Resto_integrantes),
    append(Teams_listos, [Nuevo_equipo], Aux),
    make_teams(Numeros, Resto_integrantes, Teams, Aux);
    team(N, Integrantes, Nuevo_equipo, Resto_integrantes),
    append(Teams_listos, [Nuevo_equipo], Teams).

all_teams(Numeros, Integrantes, Teams):-
    permutation(Integrantes, Perm),
    make_teams(Numeros, Perm, Teams).
