grammar Calculator;

additionExpression: multiplicationExpression ((PLUS | MINUS) multiplicationExpression)* ;
multiplicationExpression: exponentiationExpression ((MULT | DIV) exponentiationExpression)* ;
exponentiationExpression: negationExpression (POW negationExpression)* ;
negationExpression: MINUS atom | atom | sqrtExpression;
sqrtExpression: SQRT atom ;
atom: INT;

SQRT: 'sqrt' ;
INT: [0-9]+ ;
PLUS: '+' ;
MINUS: '-' ;
MULT: '*' ;
DIV: '/' ;
POW: '^' ;
WS : [ \t\r\n]+ -> skip ;
