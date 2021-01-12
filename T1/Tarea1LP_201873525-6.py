import re

#clases
class Funcion:
    variables = {}
    inputVariables = []
    retorno = None
    codigo = []
    cond_flag = False

    """
    addPlayer
    ---------------
    self: objeto Funcion
    nameVariable: string
    ---------------
    Crea un nuevo jugador y lo agrega al diccionario variables
    """
    def addPlayer(self,nameVariable):
        self.variables[nameVariable] = ""

    """
    took
    -------------
    self: Obejto Funcion
    nameVariable: string
    -------------
    Asigna valor a jugador
    """
    def took(self,nameVariable,value):
        self.variables[nameVariable] = value
    
    """
    powerUp
    -------------
    self: Obejto Funcion
    nameVariable: string
    value: string
    -------------
    Asigna valor a jugador por medio de la entrada por tecldo
    """
    def powerUp(self,nameVariable):
        self.variables[nameVariable] = input('Input: ')
    
    """
    show
    -------------
    self: Obejto Funcion
    nameVariable: string
    -------------
    Muestra valor del jugador por pantalla
    """
    def show(self,nameVariable):
        if nameVariable in self.variables:
            print(self.variables[nameVariable])
        else:
            print(nameVariable)
    
    """
    jumpsTo
    -------------
    self: Obejto Funcion
    nameVariable: string
    mathExpresion: string
    -------------
    Asigna valor a jugador por medio de una expresion numerica
    """
    def jumpsTo(self,nameVariable,mathExpression):
        pattern = re.compile(r'(?P<parentesis>\(?\d+(?P<operator>-|\*|\+|/)+\d+\)?)')
        num = re.compile(r'(?P<num>\d+)')
        newMath = mathExpression
        for var in self.variables:
            if var in mathExpression:
                newMath = newMath.replace(var,self.variables[var],1)
        while '(' in newMath or ')' in newMath:
            match = pattern.search(newMath)
            operator = match.group('operator')
            if operator == '-':
                parentesis  = match.group('parentesis')
                newMatch = num.search(parentesis)
                num1 = int(newMatch.group('num'))
                parentesis = parentesis.replace(newMatch.group('num'),'',1)
                newMatch = num.search(parentesis)
                num2 = int(newMatch.group('num'))
                resultado = num1 - num2
                newMath = newMath.replace(match.group('parentesis'),str(resultado),1)
            elif operator == '/':
                parentesis  = match.group('parentesis')
                newMatch = num.search(parentesis)
                num1 = int(newMatch.group('num'))
                parentesis = parentesis.replace(newMatch.group('num'),'',1)
                newMatch = num.search(parentesis)
                num2 = int(newMatch.group('num'))
                resultado = num1 // num2
                newMath = newMath.replace(match.group('parentesis'),str(resultado),1)
            elif operator == '+':
                parentesis  = match.group('parentesis')
                newMatch = num.search(parentesis)
                num1 = int(newMatch.group('num'))
                parentesis = parentesis.replace(newMatch.group('num'),'',1)
                newMatch = num.search(parentesis)
                num2 = int(newMatch.group('num'))
                resultado = num1 + num2
                newMath = newMath.replace(match.group('parentesis'),str(resultado),1)
            elif operator == '*':
                parentesis  = match.group('parentesis')
                newMatch = num.search(parentesis)
                num1 = int(newMatch.group('num'))
                parentesis = parentesis.replace(newMatch.group('num'),'',1)
                newMatch = num.search(parentesis)
                num2 = int(newMatch.group('num'))
                resultado = num1 * num2
                newMath = newMath.replace(match.group('parentesis'),str(resultado),1)
        self.variables[nameVariable] = str(newMath)
    
    """
    condicional
    --------------
    self: Objeto Funcion
    cond: string
    --------------
    Obtiene el valor de verdad de la expresion logica cond
    """
    def conditional(self,cond):
        pattern = re.compile(r'(?P<parentesis>\(?\d+(?P<operator>>=|<=|>|<|==|AND|OR)+\d+\)?)')
        num = re.compile(r'(?P<num>\d+)')
        boolean = re.compile(r'(?P<bool>T*F*)')
        newCond = cond
        for var in self.variables:
            if var in cond:
                newCond = newCond.replace(var,self.variables[var],1)
        while '(' in newCond or ')' in newCond:
            match = pattern.search(newCond)
            operator = match.group('operator')
            if operator == '>=':
                parentesis = match.group('parentesis')
                newMatch = num.search(parentesis)
                num1 = int(newMatch.group('num'))
                parentesis = parentesis.replace(newMatch.group('num'),'',1)
                newMatch = num.search(parentesis)
                num2 = int(newMatch.group('num'))
                if num1 >= num2:
                    newCond = newCond.replace(match.group('parentesis'),'T',1)
                else:
                    newCond = newCond.replace(match.group('parentesis'),'F',1)
            elif operator == '<=':
                parentesis = match.group('parentesis')
                newMatch = num.search(parentesis)
                num1 = int(newMatch.group('num'))
                parentesis = parentesis.replace(newMatch.group('num'),'',1)
                newMatch = num.search(parentesis)
                num2 = int(newMatch.group('num'))
                if num1 <= num2:
                    newCond = newCond.replace(match.group('parentesis'),'T',1)
                else:
                    newCond = newCond.replace(match.group('parentesis'),'F',1)
            elif operator == '>':
                parentesis = match.group('parentesis')
                newMatch = num.search(parentesis)
                num1 = int(newMatch.group('num'))
                parentesis = parentesis.replace(newMatch.group('num'),'',1)
                newMatch = num.search(parentesis)
                num2 = int(newMatch.group('num'))
                if num1 > num2:
                    newCond = newCond.replace(match.group('parentesis'),'T',1)
                else:
                    newCond = newCond.replace(match.group('parentesis'),'F',1)
            elif operator == '<':
                parentesis = match.group('parentesis')
                newMatch = num.search(parentesis)
                num1 = int(newMatch.group('num'))
                parentesis = parentesis.replace(newMatch.group('num'),'',1)
                newMatch = num.search(parentesis)
                num2 = int(newMatch.group('num'))
                if num1 < num2:
                    newCond = newCond.replace(match.group('parentesis'),'F',1)
                else:
                    newCond = newCond.replace(match.group('parentesis'),'F',1)
            elif operator == '==':
                parentesis = match.group('parentesis')
                newMatch = num.search(parentesis)
                num1 = int(newMatch.group('num'))
                parentesis = parentesis.replace(newMatch.group('num'),'',1)
                newMatch = num.search(parentesis)
                num2 = int(newMatch.group('num'))
                if num1 == num2:
                    newCond = newCond.replace(match.group('parentesis'),'T',1)
                else:
                    newCond = newCond.replace(match.group('parentesis'),'F',1)
            elif operator == 'AND':
                parentesis = match.group('parentesis')
                newMatch = boolean.search(parentesis)
                bool1 = newMatch.group('bool')
                parentesis = parentesis.replace(newMatch.group('bool'),'',1)
                newMatch = boolean.search(parentesis)
                bool2 = newMatch.group('bool')
                if bool1 == 'T' and bool2 == 'T':
                    newCond = newCond.replace(match.group('parentesis'),'T',1)
                else:
                    newCond = newCond.replace(match.group('parentesis'),'F',1)
            elif operator == 'OR':
                parentesis = match.group('parentesis')
                newMatch = boolean.search(parentesis)
                bool1 = newMatch.group('bool')
                parentesis = parentesis.replace(newMatch.group('bool'),'',1)
                newMatch = boolean.search(parentesis)
                bool2 = newMatch.group('bool')
                if bool1 == 'T' or bool2 =='T':
                    newCond = newCond.replace(match.group('parentesis'),'T',1)
                else:
                    newCond = newCond.replace(match.group('parentesis'),'F',1)
        if newCond == 'T':
            return True
        else:
            return False

    """
    iamConditional
    --------------
    self: objeto Funcion
    cond: string
    --------------
    Determina el valor de verdad de cond y segun este activa el guardado del codigo dentro del i am a conditional
    """
    def iamConditional(self,cond):
        if self.conditional(cond):
            self.if_flag = True
    
    """
    mammaMia
    --------------
    self: objeto Funcion
    detiene el guardado de codigo del if si este debia de ejecutarse, si no activa el guardado del codigo del mamm Mia
    """
    def mammaMia(self):
        if self.if_flag == False:
            self.else_flag = True                    
        else:
            self.if_flag = False
            self.not_else_flag = True

    """
    LetGo
    --------------
    self: objeto Code
    functions: diccionario
    --------------
    Ejecuta el código de un condicional
    """
    def letGo(self):
        startGame = re.compile(r'Start Game')
        gameOver = re.compile(r'Game Over')
        secretLevel = re.compile(r'Secret Level( (?P<name>\w*))?(?P<vars>(( \w*)*))')
        returnLevel = re.compile(r'Return to Level( (?P<return>\w*)?)')
        addPlayer = re.compile(r'Add Player( (?P<player>\w*)?)')
        took = re.compile(r'(?P<var>\w*)? took( (?P<value>\w*)?)')
        powerUp = re.compile(r'(?P<player>\w*) needs a power up')
        show = re.compile(r'show( (?P<var>\w*)?)')
        jumpTo = re.compile(r'(?P<var>\w*)? jumps to( (?P<expresion>(\(*\w*\+*\**/*-*\)*)*))')
        enters = re.compile(r'(?P<var>\w*) enters( (?P<function>\w*)?)( (?P<vars>\w*))*')
        conditional = re.compile(r'It\'s a me a conditional( (?P<cond>\(*\w*\d*<*>*=*\w*\d*\)*))')
        mamaMia = re.compile(r'Mamma Mia\.\.\.')
        letGo = re.compile(r'Let\'s Go!')
        yaMa = re.compile(r'YA MA( (?P<cond>\(*\w*\d*<*>*=*\w*\d*\)*)?) YAHOO!')
        ahHa = re.compile(r'AH HA!')

        self.if_flag = False
        self.else_flag = False
        self.not_else_flag = False
        self.cond_flag = False
        for l in self.condCode:
            if addPlayer.search(l):
                match = addPlayer.search(l)
                self.addPlayer(match.group('player'))
                if took.search(l):
                    match = took.search(l)
                    self.took(match.group('var'),match.group('value'))
                elif powerUp.search(l):
                    match = powerUp.search(l)
                    self.powerUp(match.group('player'))
                elif show.search(l):
                    match = show.search(l)
                    self.show(match.group('var'))
                elif jumpTo.search(l):
                    match = jumpTo.search(l)
                    self.jumpsTo(match.group('var'),match.group('expresion'))
                elif yaMa.search(line):
                    match = yaMa.search(line)
                    self.conditional(match.group('cond'))
                    c = match.group('cond')
                    if self.cond_flag:
                        self.loop_flag = True
                elif ahHa.search(line):
                    loop_flag = False
                    self.conditional(c)
                    while self.cond_flag:
                        for l in self.condCode:
                            if addPlayer.search(l):
                                match = addPlayer.search(l)
                                self.addPlayer(match.group('player'))
                            elif took.search(l):
                                match = took.search(l)
                                self.took(match.group('var'),match.group('value'))
                            elif powerUp.search(l):
                                match = powerUp.search(l)
                                self.powerUp(match.group('player'))
                            elif show.search(l):
                                match = show.search(l)
                                self.show(match.group('var'))
                            elif jumpTo.search(l):
                                match = jumpTo.search(l)
                                self.jumpsTo(match.group('var'),match.group('expresion'))
                            elif enters.search(l):
                                match = enters.search(l)
                                lista = match.group('vars').split(' ')
                                aux = []
                                for v in lista:
                                    if v in self.variables:
                                        aux.append(self.variables[v])
                                    else:
                                        aux.append(v)
                                    self.variables[match.group('var')] = functions[match.group('function')].execute(aux)
                            elif conditional.search(l):
                                match = conditional.search(l)
                                self.conditional(match.group('cond'))
                                if self.cond_flag:
                                    self.if_flag = True
                            elif mamaMia.search(l):
                                self.if_flag = False
                                self.not_else_flag = True
                            elif letGo.search(l):
                                self.if_flag = False
                                self.else_flag = False
                                self.not_else_flag = False
                                self.cond_flag = False
                                for l in self.condCode:
                                    if addPlayer.search(l):
                                        match = addPlayer.search(l)
                                        self.addPlayer(match.group('player'))
                                    elif took.search(l):
                                        match = took.search(l)
                                        self.took(match.group('var'),match.group('value'))
                                    elif powerUp.search(l):
                                        match = powerUp.search(l)
                                        self.powerUp(match.group('player'))
                                    elif show.search(l):
                                        match = show.search(l)
                                        self.show(match.group('var'))
                                    elif jumpTo.search(l):
                                        match = jumpTo.search(l)
                                        self.jumpsTo(match.group('var'),match.group('expresion'))
                                    elif enters.search(l):
                                        match = enters.search(l)
                                        lista = match.group('vars').split(' ')
                                        aux = []
                                        for v in lista:
                                            if v in self.variables:
                                                aux.append(self.variables[v])
                                            else:
                                                aux.append(v)
                                        self.variables[match.group('var')] = functions[match.group('function')].execute(aux)
                                    self.condCode = []
                            self.conditional(cond)
                        self.condCode = []
                    self.condCode = []

    """
    yaMa
    ---------------
    self: objeto Code
    cond: string
    ---------------
    Evalua el valor de verdad de cond y si corresponde guarda el codigo del Ya Ma
    """
    def yaMa(self,cond):
        if self.conditional(cond):
            self.loop_flag = True

    """
    ahHa
    ---------------
    self: objeto Code
    cond: string
    functions: diccionario
    ---------------
    Ejecuta el codigo de un Ya Ma
    """
    def ahHa(self,cond,functions):
        startGame = re.compile(r'Start Game')
        gameOver = re.compile(r'Game Over')
        secretLevel = re.compile(r'Secret Level( (?P<name>\w*))?(?P<vars>(( \w*)*))')
        returnLevel = re.compile(r'Return to Level( (?P<return>\w*)?)')
        addPlayer = re.compile(r'Add Player( (?P<player>\w*)?)')
        took = re.compile(r'(?P<var>\w*)? took( (?P<value>\w*)?)')
        powerUp = re.compile(r'(?P<player>\w*) needs a power up')
        show = re.compile(r'show( (?P<var>\w*)?)')
        jumpTo = re.compile(r'(?P<var>\w*)? jumps to( (?P<expresion>(\(*\w*\+*\**/*-*\)*)*))')
        enters = re.compile(r'(?P<var>\w*) enters( (?P<function>\w*)?)( (?P<vars>\w*))*')
        conditional = re.compile(r'It\'s a me a conditional( (?P<cond>\(*\w*\d*<*>*=*\w*\d*\)*))')
        mamaMia = re.compile(r'Mamma Mia\.\.\.')
        letGo = re.compile(r'Let\'s Go!')
        yaMa = re.compile(r'YA MA( (?P<cond>\(*\w*\d*<*>*=*\w*\d*\)*)?) YAHOO!')
        ahHa = re.compile(r'AH HA!')
        self.loop_flag = False
        self.conditional(cond)

        while self.cond_flag:
            for l in self.condCode:
                if addPlayer.search(l):
                    match = addPlayer.search(l)
                    self.addPlayer(match.group('player'))
                elif took.search(l):
                    match = took.search(l)
                    self.took(match.group('var'),match.group('value'))
                elif powerUp.search(l):
                    match = powerUp.search(l)
                    self.powerUp(match.group('player'))
                elif show.search(l):
                    match = show.search(l)
                    self.show(match.group('var'))
                elif jumpTo.search(l):
                    match = jumpTo.search(l)
                    self.jumpsTo(match.group('var'),match.group('expresion'))
                elif enters.search(l):
                    match = enters.search(l)
                    lista = match.group('vars').split(' ')
                    aux = []
                    for v in lista:
                        if v in self.variables:
                            aux.append(self.variables[v])
                        else:
                            aux.append(v)
                            self.variables[match.group('var')] = functions[match.group('function')].execute(aux)
                elif conditional.search(l):
                    match = conditional.search(l)
                    self.iamConditional(match.group('cond'))
                elif mamaMia.search(l):
                    self.mammaMia()
                elif letGo.search(l):
                    self.letGo()
            self.conditional(cond)
        self.loop.Code = []

    """
    execute
    -------------
    self: Obejto Funcion
    nameVariable: string
    -------------
    Ejecuta el codigo guardado de una funcion
    """
    def execute(self,inputList):
        addPlayer = re.compile(r'Add Player( (?P<player>\w*)?)')
        took = re.compile(r'(?P<var>\w*)? took( (?P<value>\w*)?)')
        powerUp = re.compile(r'(?P<player>\w*) needs a power up')
        show = re.compile(r'show( (?P<var>\w*)?)')
        jumpTo = re.compile(r'(?P<var>\w*)? jumps to( (?P<expresion>(\(*\w*\+*\**/*-*\)*)*))')
        conditional = re.compile(r'It\'s a me a conditional( (?P<cond>\(*\w*\d*<*>*=*\w*\d*\)*))')
        mamaMia = re.compile(r'Mamma Mia\.\.\.')
        letGo = re.compile(r'Let\'s Go!')
        yaMa = re.compile(r'YA MA( (?P<cond>\(*\w*\d*<*>*=*\w*\d*\)*)?) YAHOO!')
        ahHa = re.compile(r'AH HA!')

        for parameter in inputList:
            self.variables[self.inputVariables[inputList.index(parameter)]] = parameter
        for line in self.codigo:
            if addPlayer.search(line):
                match = addPlayer.search(line)
                self.variables[match.group('player')] = None
            elif took.search(line):
                match = took.search(line)
                self.variables[match.group('var')] = match.group('value')
            elif powerUp.search(line):
                match = powerUp.search(line)
                self.variables[match.group('var')] = input('Input: ')
            elif show.search(line):
                match = show.search(line)
                print(self.variables[match.group('var')])
            elif jumpTo.search(line):
                match = jumpTo.search(line)
                self.jumpsTo(match.group('var'),match.group('expresion'))
            elif conditional.search(line):
                match = conditional.search(line)
                self.iamConditional(match.group('cond'))
            elif mamaMia.search(line):
                self.mammaMia()
            elif letGo.search(line):
                self.letGo()
            elif yaMa.search(line):
                    match = yaMa.search(line)
                    self.conditional(match.group('cond'))
                    c = match.group('cond')
                    self.yaMa(c)
            elif ahHa.search(line):
                loop_flag = False
                main.conditional(c)
                while main.cond_flag:
                    for l in main.condCode:
                        if addPlayer.search(l):
                            match = addPlayer.search(l)
                            main.addPlayer(match.group('player'))
                        elif took.search(l):
                            match = took.search(l)
                            main.took(match.group('var'),match.group('value'))
                        elif powerUp.search(l):
                            match = powerUp.search(l)
                            main.powerUp(match.group('player'))
                        elif show.search(l):
                            match = show.search(l)
                            main.show(match.group('var'))
                        elif jumpTo.search(l):
                            match = jumpTo.search(l)
                            main.jumpsTo(match.group('var'),match.group('expresion'))
                        elif enters.search(l):
                            match = enters.search(l)
                            lista = match.group('vars').split(' ')
                            aux = []
                            for v in lista:
                                if v in main.variables:
                                    aux.append(main.variables[v])
                                else:
                                    aux.append(v)
                                    main.variables[match.group('var')] = functions[match.group('function')].execute(aux)
                            main.conditional(c)
                main.condCode = []
        if self.retorno in self.variables:
            return self.variables[self.retorno]
        else:
            return self.retorno

class Code:
    variables = {}
    condCode = []
    loopCode = []
    cond_flag = False
    if_flag = False
    else_flag = False
    not_else_flag = False
    loop_flag = False

    """
    addPlayer
    ---------------
    self: objeto Code
    nameVariable: string
    ---------------
    Crea un nuevo jugador y lo agrega al diccionario variables
    """
    def addPlayer(self,nameVariable):
        self.variables[nameVariable] = None
    
    """
    took
    -------------
    self: Obejto Code
    nameVariable: string
    -------------
    Asigna valor a jugador
    """
    def took(self,nameVariable,value):
        self.variables[nameVariable] = value
    
    """
    powerUp
    -------------
    self: Obejto Code
    nameVariable: string
    value: string
    -------------
    Asigna valor a jugador por medio de la entrada por tecldo
    """
    def powerUp(self,nameVariable):
        self.variables[nameVariable] = input('Input: ')
    
    """
    show
    -------------
    self: Obejto Code
    nameVariable: string
    -------------
    Muestra valor del jugador por pantalla
    """
    def show(self,nameVariable):
        if nameVariable in self.variables:
            print(self.variables[nameVariable])
        else:
            print(nameVariable)
    
    """
    jumpsTo
    -------------
    self: Obejto Code
    nameVariable: string
    mathExpresion: string
    -------------
    Asigna valor a jugador por medio de una expresion numerica
    """
    def jumpsTo(self,nameVariable,mathExpression):
        pattern = re.compile(r'(?P<parentesis>\(?\d+(?P<operator>-|\*|\+|/)+\d+\)?)')
        num = re.compile(r'(?P<num>\d+)')
        newMath = mathExpression
        for var in self.variables:
            if var in mathExpression:
                newMath = newMath.replace(var,self.variables[var],1)
        while '(' in newMath or ')' in newMath:
            match = pattern.search(newMath)
            operator = match.group('operator')
            if operator == '-':
                parentesis = match.group('parentesis')
                newMatch = num.search(parentesis)
                num1 = int(newMatch.group('num'))
                parentesis = parentesis.replace(newMatch.group('num'),'',1)
                newMatch = num.search(parentesis)
                num2 = int(newMatch.group('num'))
                resultado = num1 - num2
                newMath = newMath.replace(match.group('parentesis'),str(resultado),1)
            elif operator == '/':
                parentesis  = match.group('parentesis')
                newMatch = num.search(parentesis)
                num1 = int(newMatch.group('num'))
                parentesis = parentesis.replace(newMatch.group('num'),'',1)
                newMatch = num.search(parentesis)
                num2 = int(newMatch.group('num'))
                resultado = num1 // num2
                newMath = newMath.replace(match.group('parentesis'),str(resultado),1)
            elif operator == '+':
                parentesis  = match.group('parentesis')
                newMatch = num.search(parentesis)
                num1 = int(newMatch.group('num'))
                parentesis = parentesis.replace(newMatch.group('num'),'',1)
                newMatch = num.search(parentesis)
                num2 = int(newMatch.group('num'))
                resultado = num1 + num2
                newMath = newMath.replace(match.group('parentesis'),str(resultado),1)
            elif operator == '*':
                parentesis  = match.group('parentesis')
                newMatch = num.search(parentesis)
                num1 = int(newMatch.group('num'))
                parentesis = parentesis.replace(newMatch.group('num'),'',1)
                newMatch = num.search(parentesis)
                num2 = int(newMatch.group('num'))
                resultado = num1 * num2
                newMath = newMath.replace(match.group('parentesis'),str(resultado),1)
        self.variables[nameVariable] = str(newMath)

    """
    condicional
    --------------
    self: Objeto Code
    cond: string
    --------------
    Obtiene el valor de verdad de la expresion logica cond
    """
    def conditional(self,cond):
        pattern = re.compile(r'(?P<parentesis>\(?\d+(?P<operator>>=|<=|>|<|==|AND|OR)+\d+\)?)')
        num = re.compile(r'(?P<num>\d+)')
        boolean = re.compile(r'(?P<bool>T*F*)')
        newCond = cond
        for var in self.variables:
            if var in cond:
                newCond = newCond.replace(var,self.variables[var],1)
        while '(' in newCond or ')' in newCond:
            match = pattern.search(newCond)
            operator = match.group('operator')
            if operator == '>=':
                parentesis = match.group('parentesis')
                newMatch = num.search(parentesis)
                num1 = int(newMatch.group('num'))
                parentesis = parentesis.replace(newMatch.group('num'),'',1)
                newMatch = num.search(parentesis)
                num2 = int(newMatch.group('num'))
                if num1 >= num2:
                    newCond = newCond.replace(match.group('parentesis'),'T',1)
                else:
                    newCond = newCond.replace(match.group('parentesis'),'F',1)
            elif operator == '<=':
                parentesis = match.group('parentesis')
                newMatch = num.search(parentesis)
                num1 = int(newMatch.group('num'))
                parentesis = parentesis.replace(newMatch.group('num'),'',1)
                newMatch = num.search(parentesis)
                num2 = int(newMatch.group('num'))
                if num1 <= num2:
                    newCond = newCond.replace(match.group('parentesis'),'T',1)
                else:
                    newCond = newCond.replace(match.group('parentesis'),'F',1)
            elif operator == '>':
                parentesis = match.group('parentesis')
                newMatch = num.search(parentesis)
                num1 = int(newMatch.group('num'))
                parentesis = parentesis.replace(newMatch.group('num'),'',1)
                newMatch = num.search(parentesis)
                num2 = int(newMatch.group('num'))
                if num1 > num2:
                    newCond = newCond.replace(match.group('parentesis'),'T',1)
                else:
                    newCond = newCond.replace(match.group('parentesis'),'F',1)
            elif operator == '<':
                parentesis = match.group('parentesis')
                newMatch = num.search(parentesis)
                num1 = int(newMatch.group('num'))
                parentesis = parentesis.replace(newMatch.group('num'),'',1)
                newMatch = num.search(parentesis)
                num2 = int(newMatch.group('num'))
                if num1 < num2:
                    newCond = newCond.replace(match.group('parentesis'),'F',1)
                else:
                    newCond = newCond.replace(match.group('parentesis'),'F',1)
            elif operator == '==':
                parentesis = match.group('parentesis')
                newMatch = num.search(parentesis)
                num1 = int(newMatch.group('num'))
                parentesis = parentesis.replace(newMatch.group('num'),'',1)
                newMatch = num.search(parentesis)
                num2 = int(newMatch.group('num'))
                if num1 == num2:
                    newCond = newCond.replace(match.group('parentesis'),'T',1)
                else:
                    newCond = newCond.replace(match.group('parentesis'),'F',1)
            elif operator == 'AND':
                parentesis = match.group('parentesis')
                newMatch = boolean.search(parentesis)
                bool1 = newMatch.group('bool')
                parentesis = parentesis.replace(newMatch.group('bool'),'',1)
                newMatch = boolean.search(parentesis)
                bool2 = newMatch.group('bool')
                if bool1 == 'T' and bool2 == 'T':
                    newCond = newCond.replace(match.group('parentesis'),'T',1)
                else:
                    newCond = newCond.replace(match.group('parentesis'),'F',1)
            elif operator == 'OR':
                parentesis = match.group('parentesis')
                newMatch = boolean.search(parentesis)
                bool1 = newMatch.group('bool')
                parentesis = parentesis.replace(newMatch.group('bool'),'',1)
                newMatch = boolean.search(parentesis)
                bool2 = newMatch.group('bool')
                if bool1 == 'T' or bool2 =='T':
                    newCond = newCond.replace(match.group('parentesis'),'T',1)
                else:
                    newCond = newCond.replace(match.group('parentesis'),'F',)
        if newCond == 'T':
            return True
        else:
            return False

    """
    iamConditional
    --------------
    self: objeto Code
    cond: string
    --------------
    Determina el valor de verdad de cond y segun este activa el guardado del codigo dentro del i am a conditional
    """
    def iamConditional(self,cond):
        if self.conditional(cond):
            self.if_flag = True

    """
    mammaMia
    --------------
    self: objeto Code
    detiene el guardado de codigo del if si este debia de ejecutarse, si no activa el guardado del codigo del mamm Mia
    """
    def mammaMia(self):
        if self.if_flag == False:
            self.else_flag = True                    
        else:
            self.if_flag = False
            self.not_else_flag = True
    
    """
    LetGo
    --------------
    self: objeto Code
    functions: diccionario
    --------------
    Ejecuta el código de un condicional
    """
    def letGo(self,functions):
        startGame = re.compile(r'Start Game')
        gameOver = re.compile(r'Game Over')
        secretLevel = re.compile(r'Secret Level( (?P<name>\w*))?(?P<vars>(( \w*)*))')
        returnLevel = re.compile(r'Return to Level( (?P<return>\w*)?)')
        addPlayer = re.compile(r'Add Player( (?P<player>\w*)?)')
        took = re.compile(r'(?P<var>\w*)? took( (?P<value>\w*)?)')
        powerUp = re.compile(r'(?P<player>\w*) needs a power up')
        show = re.compile(r'show( (?P<var>\w*)?)')
        jumpTo = re.compile(r'(?P<var>\w*)? jumps to( (?P<expresion>(\(*\w*\+*\**/*-*\)*)*))')
        enters = re.compile(r'(?P<var>\w*) enters( (?P<function>\w*)?)( (?P<vars>\w*))*')
        conditional = re.compile(r'It\'s a me a conditional( (?P<cond>\(*\w*\d*<*>*=*\w*\d*\)*))')
        mamaMia = re.compile(r'Mamma Mia\.\.\.')
        letGo = re.compile(r'Let\'s Go!')
        yaMa = re.compile(r'YA MA( (?P<cond>\(*\w*\d*<*>*=*\w*\d*\)*)?) YAHOO!')
        ahHa = re.compile(r'AH HA!')

        self.if_flag = False
        self.else_flag = False
        self.not_else_flag = False
        self.cond_flag = False
        for l in self.condCode:
            if addPlayer.search(l):
                match = addPlayer.search(l)
                self.addPlayer(match.group('player'))
                if took.search(l):
                    match = took.search(l)
                    self.took(match.group('var'),match.group('value'))
                elif powerUp.search(l):
                    match = powerUp.search(l)
                    self.powerUp(match.group('player'))
                elif show.search(l):
                    match = show.search(l)
                    self.show(match.group('var'))
                elif jumpTo.search(l):
                    match = jumpTo.search(l)
                    self.jumpsTo(match.group('var'),match.group('expresion'))
                elif enters.search(l):
                    match = enters.search(l)
                    lista = match.group('vars').split(' ')
                    aux = []
                    for v in lista:
                        if v in self.variables:
                            aux.append(self.variables[v])
                        else:
                            aux.append(v)
                    self.variables[match.group('var')] = functions[match.group('function')].execute(aux)
                elif yaMa.search(line):
                    match = yaMa.search(line)
                    self.conditional(match.group('cond'))
                    c = match.group('cond')
                    if self.cond_flag:
                        self.loop_flag = True
                elif ahHa.search(line):
                    loop_flag = False
                    self.conditional(c)
                    while self.cond_flag:
                        for l in self.condCode:
                            if addPlayer.search(l):
                                match = addPlayer.search(l)
                                self.addPlayer(match.group('player'))
                            elif took.search(l):
                                match = took.search(l)
                                self.took(match.group('var'),match.group('value'))
                            elif powerUp.search(l):
                                match = powerUp.search(l)
                                self.powerUp(match.group('player'))
                            elif show.search(l):
                                match = show.search(l)
                                self.show(match.group('var'))
                            elif jumpTo.search(l):
                                match = jumpTo.search(l)
                                self.jumpsTo(match.group('var'),match.group('expresion'))
                            elif enters.search(l):
                                match = enters.search(l)
                                lista = match.group('vars').split(' ')
                                aux = []
                                for v in lista:
                                    if v in self.variables:
                                        aux.append(self.variables[v])
                                    else:
                                        aux.append(v)
                                    self.variables[match.group('var')] = functions[match.group('function')].execute(aux)
                            elif conditional.search(l):
                                match = conditional.search(l)
                                self.conditional(match.group('cond'))
                                if self.cond_flag:
                                    self.if_flag = True
                            elif mamaMia.search(l):
                                self.if_flag = False
                                self.not_else_flag = True
                            elif letGo.search(l):
                                self.if_flag = False
                                self.else_flag = False
                                self.not_else_flag = False
                                self.cond_flag = False
                                for l in self.condCode:
                                    if addPlayer.search(l):
                                        match = addPlayer.search(l)
                                        self.addPlayer(match.group('player'))
                                    elif took.search(l):
                                        match = took.search(l)
                                        self.took(match.group('var'),match.group('value'))
                                    elif powerUp.search(l):
                                        match = powerUp.search(l)
                                        self.powerUp(match.group('player'))
                                    elif show.search(l):
                                        match = show.search(l)
                                        self.show(match.group('var'))
                                    elif jumpTo.search(l):
                                        match = jumpTo.search(l)
                                        self.jumpsTo(match.group('var'),match.group('expresion'))
                                    elif enters.search(l):
                                        match = enters.search(l)
                                        lista = match.group('vars').split(' ')
                                        aux = []
                                        for v in lista:
                                            if v in self.variables:
                                                aux.append(self.variables[v])
                                            else:
                                                aux.append(v)
                                        self.variables[match.group('var')] = functions[match.group('function')].execute(aux)
                                    self.condCode = []
                            self.conditional(cond)
                        self.condCode = []
                    self.condCode = []

    """
    yaMa
    ---------------
    self: objeto Code
    cond: string
    ---------------
    Evalua el valor de verdad de cond y si corresponde guarda el codigo del Ya Ma
    """
    def yaMa(self,cond):
        if self.conditional(cond):
            self.loop_flag = True

    """
    ahHa
    ---------------
    self: objeto Code
    cond: string
    functions: diccionario
    ---------------
    Ejecuta el codigo de un Ya Ma
    """
    def ahHa(self,cond,functions):
        startGame = re.compile(r'Start Game')
        gameOver = re.compile(r'Game Over')
        secretLevel = re.compile(r'Secret Level( (?P<name>\w*))?(?P<vars>(( \w*)*))')
        returnLevel = re.compile(r'Return to Level( (?P<return>\w*)?)')
        addPlayer = re.compile(r'Add Player( (?P<player>\w*)?)')
        took = re.compile(r'(?P<var>\w*)? took( (?P<value>\w*)?)')
        powerUp = re.compile(r'(?P<player>\w*) needs a power up')
        show = re.compile(r'show( (?P<var>\w*)?)')
        jumpTo = re.compile(r'(?P<var>\w*)? jumps to( (?P<expresion>(\(*\w*\+*\**/*-*\)*)*))')
        enters = re.compile(r'(?P<var>\w*) enters( (?P<function>\w*)?)( (?P<vars>\w*))*')
        conditional = re.compile(r'It\'s a me a conditional( (?P<cond>\(*\w*\d*<*>*=*\w*\d*\)*))')
        mamaMia = re.compile(r'Mamma Mia\.\.\.')
        letGo = re.compile(r'Let\'s Go!')
        yaMa = re.compile(r'YA MA( (?P<cond>\(*\w*\d*<*>*=*\w*\d*\)*)?) YAHOO!')
        ahHa = re.compile(r'AH HA!')

        self.loop_flag = False
        self.conditional(cond)
        while self.conditional(c):
            for l in self.loopCode:
                if addPlayer.search(l):
                    match = addPlayer.search(l)
                    self.addPlayer(match.group('player'))
                elif took.search(l):
                    match = took.search(l)
                    self.took(match.group('var'),match.group('value'))
                elif powerUp.search(l):
                    match = powerUp.search(l)
                    self.powerUp(match.group('player'))
                elif show.search(l):
                    match = show.search(l)
                    self.show(match.group('var'))
                elif jumpTo.search(l):
                    match = jumpTo.search(l)
                    self.jumpsTo(match.group('var'),match.group('expresion'))
                elif enters.search(l):
                    match = enters.search(l)
                    lista = match.group('vars').split(' ')
                    aux = []
                    for v in lista:
                        if v in self.variables:
                            aux.append(self.variables[v])
                        else:
                            aux.append(v)
                            main.variables[match.group('var')] = functions[match.group('function')].execute(aux)
                elif conditional.search(l):
                    match = conditional.search(l)
                    self.conditional(match.group('cond'))
                    if self.conditional(cond):
                        self.if_flag = True
                elif mamaMia.search(l):
                    self.if_flag = False
                    self.not_else_flag = True
                elif letGo.search(l):
                    self.if_flag = False
                    self.else_flag = False
                    self.not_else_flag = False
                    self.main.cond_flag = False
                    for l in self.condCode:
                        if addPlayer.search(l):
                            match = addPlayer.search(l)
                            self.addPlayer(match.group('player'))
                        elif took.search(l):
                            match = took.search(l)
                            self.took(match.group('var'),match.group('value'))
                        elif powerUp.search(l):
                            match = powerUp.search(l)
                            self.powerUp(match.group('player'))
                        elif show.search(l):
                            match = show.search(l)
                            self.show(match.group('var'))
                        elif jumpTo.search(l):
                            match = jumpTo.search(l)
                            self.jumpsTo(match.group('var'),match.group('expresion'))
                        elif enters.search(l):
                            match = enters.search(l)
                            lista = match.group('vars').split(' ')
                            aux = []
                            for v in lista:
                                if v in self.variables:
                                    aux.append(self.variables[v])
                                else:
                                    aux.append(v)
                                    main.variables[match.group('var')] = functions[match.group('function')].execute(aux)
                    self.condCode = []
        self.loopCode = []

#variables
file = []
functions = {}
function_flag = False
error_flag = True
main = Code()
aux = 0
ciclos = {}

#patterns
startGame = re.compile(r'Start Game')
gameOver = re.compile(r'Game Over')
secretLevel = re.compile(r'Secret Level( (?P<name>\w*))?(?P<vars>(( \w*)*))')
returnLevel = re.compile(r'Return to Level( (?P<return>\w*)?)')
addPlayer = re.compile(r'Add Player( (?P<player>\w*)?)')
took = re.compile(r'(?P<var>\w*)? took( (?P<value>\w*)?)')
powerUp = re.compile(r'(?P<player>\w*) needs a power up')
show = re.compile(r'show( (?P<var>\w*)?)')
jumpTo = re.compile(r'(?P<var>\w*)? jumps to( (?P<expresion>(\(*\w*\+*\**/*-*\)*)*))')
enters = re.compile(r'(?P<var>\w*) enters( (?P<function>\w*)?)( (?P<vars>\w*))*')
conditional = re.compile(r'It\'s a me a conditional( (?P<cond>\(*\w*\d*<*>*=*\w*\d*\)*))')
mamaMia = re.compile(r'Mamma Mia\.\.\.')
letGo = re.compile(r'Let\'s Go!')
yaMa = re.compile(r'YA MA( (?P<cond>\(*\w*\d*<*>*=*\w*\d*\)*)?) YAHOO!')
ahHa = re.compile(r'AH HA!')

arch = open('yahooo.txt')
for line in arch:
    file.append(line.strip())
    if startGame.search(line):
        error_flag = False
    elif gameOver.search(line):
        error_flag = False
    elif secretLevel.search(line):
        error_flag = False
    elif returnLevel.search(line):
        error_flag = False
    elif addPlayer.search(line):
        error_flag = False
    elif took.search(line):
        error_flag = False    
    elif powerUp.search(line):
        error_flag = False
    elif show.search(line):
        error_flag = False        
    elif jumpTo.search(line):
        error_flag = False
    elif enters.search(line):
        error_flag = False        
    elif conditional.search(line):
        error_flag = False
    elif mamaMia.search(line):
        error_flag = False
    elif letGo.search(line):
        error_flag = False
    elif yaMa.search(line):
        error_flag = False
    elif ahHa.search(line):
        error_flag = False
arch.close()
#TENGO QUE ARREGLAR EL PROBLEMA DE CICLOS ANIDADOS Y CONDICIONALES CON CICLOS ADENTRO
if 'Start Game' in file:
    if 'Game Over' in file:
        arch = open('yahooo.txt')
        cont = 0
        if(error_flag):
            print('-----Consola-----')
        for line in file:
            if startGame.search(line):
                continue
            elif gameOver.search(line):
                continue
            elif secretLevel.search(line):
                if (error_flag):
                    continue
                else:
                    match = secretLevel.search(line)
                    funcion = match.group('name')
                    functions[funcion] = Funcion()
                    inputVars = match.group('vars').split(' ')
                    inputVars.remove('')
                    for var in inputVars:
                        functions[funcion].inputVariables.append(var)
                        functions[funcion].variables[var] = 0
                    function_flag = True
            elif returnLevel.search(line):
                if (error_flag):
                    continue
                else:
                    #guardamos el retorno (nombre de variable o string de numero constante)
                    match = returnLevel.search(line)
                    functions[funcion].retorno = match.group('return')
                    function_flag = False
            elif addPlayer.search(line):
                if error_flag:
                    pass
                else:
                    if function_flag:
                        functions[funcion].codigo.append(line.strip())
                    elif main.if_flag:
                        main.condCode.append(line.strip())
                    elif main.else_flag:
                        main.condCode.append(line.strip())
                    elif main.not_else_flag:
                        aux += 1
                    elif main.loop_flag:
                        main.loopCode.append(line.strip())
                    else:
                        match = addPlayer.search(line)
                        main.addPlayer(match.group('player'))
            elif took.search(line):
                if (error_flag):
                    continue
                else:
                    if function_flag:
                        functions[funcion].codigo.append(line.strip())
                    elif main.if_flag:
                        main.condCode.append(line.strip())
                    elif main.else_flag:
                        main.condCode.append(line.strip())
                    elif main.not_else_flag:
                        aux += 1
                    elif main.loop_flag:
                        main.loopCode.append(line.strip())
                    else:
                        match = took.search(line)
                        main.took(match.group('var'),match.group('value'))
            elif powerUp.search(line):
                if (error_flag):
                    continue
                else:
                    if function_flag:
                        functions[funcion].codigo.append(line.strip())
                    elif main.if_flag:
                        main.condCode.append(line.strip())
                    elif main.else_flag:
                        main.condCode.append(line.strip())
                    elif main.not_else_flag:
                        aux += 1
                    elif main.loop_flag:
                        main.loopCode.append(line.strip())
                    else:
                        match = powerUp.search(line)
                        main.powerUp(match.group('player'))
            elif show.search(line):
                if (error_flag):
                    continue
                else:
                    if function_flag:
                        functions[funcion].codigo.append(line.strip())
                    elif main.if_flag:
                        print('lo hace')
                        main.condCode.append(line.strip())
                    elif main.else_flag:
                        main.condCode.append(line.strip())
                    elif main.not_else_flag:
                        aux += 1
                    elif main.loop_flag:
                        main.loopCode.append(line.strip())
                    else:
                        match = show.search(line)
                        main.show(match.group('var'))
            elif jumpTo.search(line):
                if error_flag:
                    continue
                else:
                    if function_flag:
                        functions[funcion].codigo.append(line.strip())
                    elif main.if_flag:
                        main.condCode.append(line.strip())
                    elif main.else_flag:
                        main.condCode.append(line.strip())
                    elif main.not_else_flag:
                        aux += 1
                    elif main.loop_flag:
                        main.loopCode.append(line.strip())
                    else:
                        match = jumpTo.search(line)
                        main.jumpsTo(match.group('var'),match.group('expresion'))
            elif enters.search(line):
                if (error_flag):
                    continue
                else:
                    if main.if_flag:
                        main.condCode.append(line.strip())
                    elif main.else_flag:
                        main.condCode.append(line.strip())
                    elif main.not_else_flag:
                        aux += 1
                    elif main.loop_flag:
                        main.loopCode.append(line.strip())
                    else:
                        match = enters.search(line)
                        lista = match.group('vars').split(' ')
                        aux = []
                        for v in lista:
                            if v in main.variables:
                                aux.append(main.variables[v])
                            else:
                                aux.append(v)
                        main.variables[match.group('var')] = functions[match.group('function')].execute(aux)
            elif conditional.search(line):
                if (error_flag):
                    continue
                elif function_flag:
                    functions[funcion].codigo.append(line.strip())
                elif main.loop_flag:
                    main.loopCode.append(line.strip())
                else:
                    match = conditional.search(line)
                    cond = match.group('cond')
                    main.iamConditional(cond)
            elif mamaMia.search(line):
                if (error_flag):
                    continue
                elif main.loop_flag:
                    main.loopCode.append(line.strip())
                else:
                    main.mammaMia()
            elif letGo.search(line):
                if error_flag:
                    continue
                elif function_flag:
                    functions[funcion].codigo.append(line.strip())
                elif main.loop_flag:
                    main.loopCode.append(line.strip())
                else:
                    main.letGo(functions)
            elif yaMa.search(line):
                if error_flag:
                    continue
                else:
                    if function_flag:
                        functions[funcion].codigo.append(line.strip())
                    elif main.if_flag:
                        main.condCode.append(line.strip())
                    elif main.else_flag:
                        main.loopCode.append(line.strip())
                    elif main.not_else_flag:
                        aux += 1
                    elif main.loop_flag:
                        main.condCode.append(line.strip())
                    else:
                        match = yaMa.search(line)
                        main.conditional(match.group('cond'))
                        c = match.group('cond')
                        main.yaMa(c)
            elif ahHa.search(line):
                if (error_flag):
                    continue
                else:
                    if function_flag:
                        functions[funcion].codigo.append(line.strip())
                    elif main.if_flag:
                        main.condCode.append(line.strip())
                    elif main.else_flag:
                        main.condCode.append(line.strip())
                    elif main.not_else_flag:
                        aux += 1
                    else:
                        main.ahHa(c,functions)
            else:
                print("woooooooohhhh!"+str(file.index(line)+1)+': '+line.strip())
        arch.close()
    else:
        print('No se encontro Game Over')
else:
    print('No se encontro Start Game')