grammar Calculator;

expression: multiplicationExpression ((PLUS | MINUS) multiplicationExpression)* ;
multiplicationExpression: powExpression ((MULT | DIV) powExpression)* ;
powExpression: integralExpression ((POW) integralExpression)* ;
integralExpression: MINUS integralExpression | INT | SQRT integralExpression;

SQRT: 'sqrt' ;
INT: [0-9]+ ;
PLUS: '+' ;
MINUS: '-' ;
MULT: '*' ;
DIV: '/' ;
POW: '^' ;
WS : [ \t\r\n]+ -> skip ;
