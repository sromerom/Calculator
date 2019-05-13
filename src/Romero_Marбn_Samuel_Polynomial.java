import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Polynomial {

    float[] coe;


    // Constructor per defecte. Genera un polinomi zero
    public Polynomial() {
        this.coe = new float[]{0};
    }

    // Constructor a partir dels coeficients del polinomi en forma d'array
    public Polynomial(float[] cfs) {
        int comptaZeros = 0;
        float[] temp = new float[cfs.length];

        //bucle per saber si tots els coeficients son 0 i si ho son donar com resultat 0.
        for (int g = 0; g < cfs.length; g++) {
            if (cfs[g] == 0) {
                comptaZeros++;
            }
        }
        //Si el contador de 0 que hem creat abans es exactament igual a la longitud del array vol dir que tot el nombres son 0 i per
        //tant hem de retornar 0.
        if (comptaZeros == cfs.length) {
            this.coe = new float[]{0};
        } else { //Si no tots son zeros, utilitzam la funció que elimina els 0 necesaris.
            this.coe = llevarZeros(cfs);
        }
    }

    // Constructor a partir d'un string
    public Polynomial(String s) {
        String[] separate = s.split(" ");
        String signeActual = "";
        int maximGrau = 0;
        float sumaCoeficientGrau0 = 0;
        float sumaCoeficientGrau1 = 0;
        float sumaCoeficientTotsGrau = 0;
        int comptaZeros = 0;
        int cont = 0;
        int siNoConteGrauMajor = 0;

        //Aconseguir el maxim de tamany que sera l'array
        for (int i = 0; i < separate.length; i++) {
            String actualExponent = separate[i];

            //Si el actual monomi conte un elevat aconseguim el numero que hi ha despres d'aquest elevat (signe)
            if (actualExponent.contains("^")) {
                String[] exponentMesGran = actualExponent.split("\\^");
                cont = Integer.parseInt(exponentMesGran[1]);
                //Emmagatzenam sempre el numero de exponent mes gran fins ara
                if (maximGrau < cont) {
                    maximGrau = cont;
                }
            } else {
                siNoConteGrauMajor++;
            }

            if (siNoConteGrauMajor == separate.length) {
                for (int llevarSignes = 0; llevarSignes < separate.length; llevarSignes++) {
                    if (!separate[llevarSignes].contains("-") && !separate[llevarSignes].contains("+")) {
                        cont++;
                        maximGrau = cont;
                    }
                }
            }
        }

        if (siNoConteGrauMajor == separate.length) {
            coe = new float[maximGrau];
        } else {
            //El exponent guardat mes gran l'afegim al tamany maxim del array que crearem + 1.
            coe = new float[maximGrau + 1];
        }

        //For a on es conseguir introduir tots els numeros dels string al array
        for (int coeNum = 0; coeNum < separate.length; coeNum++) {
            String actualCoeficient = separate[coeNum];

            //Primer aconseguiem el signe actual que hi ha en el string el guardarem per posteriorment utiltizarlo per fer operacions
            Pattern restriccio = Pattern.compile("[0-9]+");
            Matcher restriccioCoe = restriccio.matcher(actualCoeficient);
            boolean conteNumeros = restriccioCoe.find();

            //Si el string NO conte numeros i conte els signes + o - procedirem a omplir la variable signeActual per guardar el signe
            if (!conteNumeros) {
                if ((actualCoeficient.contains("+") || actualCoeficient.contains("-"))) {
                    signeActual = actualCoeficient;
                }
            }

            ////////////////////////////////////////////////
            //Començam a colocar en el seu lloc (del array[n]) tots els exponents majors que 1
            ////////////////////////////////////////////////

            if (actualCoeficient.contains("^")) {
                int auxExpo;
                String auxCoe;
                //Primer aconseguirem quin grau del exponent es, per posteriorment saber a quin lloc del array s'escriura
                String[] grauExponent = actualCoeficient.split("\\^");
                //Exponent
                auxExpo = Integer.parseInt(grauExponent[1]);

                //I ara aconseguirem el coeficient
                float numeroCoeficientFloat = 0;

                //Part a on genera error!! Un coeficient sense cap numero com a coeficient (-x^2), si feim un split sense fer cap condicció només
                //agafarà el signe -, i donarà error ja que no el podem pasar com float. Per aquest error falla la suma i la multiplicació
                //
                //if (.equals("-x") || .equals("x")) {
                //{ else {
                // String[] numeroCoeficient = grauExponent[0].split("x");
                // }
                //
                //

                //Separam el string que conte el exponent i nomes deixam el coeficient d'aquest mateix exponent
                String[] numeroCoeficient = grauExponent[0].split("x");

                //Si no te numero al coeficient i simplement esta la x sempre hi sumarem 1
                if (numeroCoeficient.length == 0) {
                    numeroCoeficientFloat = 1;
                } else if (numeroCoeficient[0].equals("-")) {
                    numeroCoeficientFloat = -1;
                } else { //Si te numero el guardarem i el posam dins la variable
                    numeroCoeficientFloat = Float.parseFloat(numeroCoeficient[0]);
                }

                //Ara s'introduira aquest numero (que ara esta en la variable), de dins l'array
                if (signeActual.equals("-")) {
                    numeroCoeficientFloat = numeroCoeficientFloat * (-1);
                }
                //Si es el primer numero que s'introduix al array (del mateix grau) no cal fer suma
                if (coe[auxExpo] == 0) {
                    coe[auxExpo] = numeroCoeficientFloat;
                } else { //Si ja s'ha introduit mes d'un numero farem la operació corresponent

                    //Si el anterior signe que hem agafat abans es igual a - farem una resta i el mateix amb la suma.
                    coe[auxExpo] = sumaCoeficientTotsGrau + numeroCoeficientFloat;
                }

                //I guardam el resultat que ens ha donat per desprès si torna a veure un numero del mateix grau poder sumar el ultim nombre amb el nou
                sumaCoeficientTotsGrau = coe[auxExpo];
            }

            ////////////////////////////////////////////////
            //Si el array conte un coeficient amb exponent 1, començarem a colocar de dins el array[1] tots aquests
            ////////////////////////////////////////////////

            if (!actualCoeficient.contains("^") && actualCoeficient.contains("x")) {

                float numeroCoeficientFloat2;

                //Separarem el string despres d'una "x" per aconsguir el coeficient de exponent 1
                String[] desCoeNum2 = actualCoeficient.split("x");

                //Si no te numero al coeficient i simplement esta la x sempre hi sumarem 1
                if (desCoeNum2.length == 0) {
                    numeroCoeficientFloat2 = 1;
                } else { //Si te numero, el guardarem i el posam dins la variable
                    numeroCoeficientFloat2 = Float.parseFloat(desCoeNum2[0]);
                }

                //Ara s'introduira aquest numero (que ara esta en la variable), de dins l'array
                if (signeActual.equals("-")) {
                    numeroCoeficientFloat2 = numeroCoeficientFloat2 * (-1);
                }
                //Si es el primer numero que s'introduix al array (del mateix grau) no cal fer suma
                //En aquest cas sempre introduirem el coeficients dins la posicio 1 ja que son exponents 1
                if (this.coe[1] == 0) {
                    this.coe[1] = numeroCoeficientFloat2;
                } else {
                    //Si el anterior signe que hem agafat abans es igual a - farem una resta i el mateix amb la suma.
                    this.coe[1] = sumaCoeficientGrau1 + numeroCoeficientFloat2;

                }


                //I guardam el resultat que ens ha donat per desprès si torna a veure un numero del mateix grau poder sumar el ultim nombre amb el nou
                sumaCoeficientGrau1 = this.coe[1];
            }

            ////////////////////////////////////////////////
            //Si el exponent es grau 0, colocam tots els coeficients al array[0]
            ////////////////////////////////////////////////
            if (!actualCoeficient.contains("^") && !actualCoeficient.contains("x") && actualCoeficient.matches("[0-9]+")) {
                //Coeficient
                float numeroCoeficientFloat3;
                numeroCoeficientFloat3 = Float.parseFloat(actualCoeficient);
                if (signeActual.equals("-")) {
                    numeroCoeficientFloat3 = numeroCoeficientFloat3 * (-1);
                }
                this.coe[0] = sumaCoeficientGrau0 + numeroCoeficientFloat3;
                sumaCoeficientGrau0 = this.coe[0];

            }
        }

        //Ara hem d'ordenar el array correctament. Cridam a la funció ordenar
        ordenarArray(coe);

        //Contam tots els zeros
        for (int g = 0; g < coe.length; g++) {
            if (this.coe[g] == 0) {
                comptaZeros++;
            }
        }
        //I llevam tots el zeros innecesaris del array
        if (comptaZeros == coe.length) {
            this.coe = new float[]{0};
        } else { // I si no, com en el primer constructor, llevarem tots els 0 innecesaris. Cridam a la funció llevar Zeros
            this.coe = llevarZeros(coe);
        }


    }

    private void ordenarArray(float[] coe) {
        for (int ordenar = 0; ordenar < coe.length / 2; ordenar++) {
            float t = coe[ordenar];
            float t2 = coe[(coe.length - 1) - ordenar];

            coe[ordenar] = t2;
            coe[coe.length - 1 - ordenar] = t;
        }
    }

    private static float[] llevarZeros(float[] coe) {
        int cont2 = 0;
        float[] temp2 = new float[coe.length];
        if (coe[0] != 0) {
            temp2 = new float[coe.length];
            for (int i = 0; i < coe.length; i++) {
                temp2[i] = coe[i];
            }
        } else {
            for (int i = 0; i < coe.length; i++) {
                if (coe[i] != 0) {
                    temp2[i] = coe[i];
                    break;
                } else {
                    cont2++;
                }
            }

            //Una vegada llevat tots els 0 innecesaris pasarem al array coe el resultat net
            //Pasar el array correctament
            coe = new float[temp2.length - cont2];
            int coet = 0;
            for (int i = 0; i < temp2.length; i++) {
                if (temp2[i] != 0) {
                    coe[coet] = temp2[i];
                    coet++;
                }
            }
        }
        return coe;
    }

    // Suma el polinomi amb un altre. No modifica el polinomi actual (this). Genera un de nou
    public Polynomial add(Polynomial p) {
        //this.coe

        float[] NewCoeSum;
        int recorrP;
        int recorrCoe;
        if (p.coe.length > this.coe.length || p.coe.length == this.coe.length) {
            NewCoeSum = new float[p.coe.length];
            recorrCoe = this.coe.length - 1;

            for (recorrP = p.coe.length - 1; recorrP >= 0; recorrP--, recorrCoe--) {
                if (recorrCoe < 0) {
                    break;
                }
                NewCoeSum[recorrP] = p.coe[recorrP] + this.coe[recorrCoe];
            }
            for (int acabarP = recorrP; acabarP >= 0; acabarP--) { //recorrP = 5
                NewCoeSum[acabarP] = p.coe[acabarP];
            }
        } else {
            NewCoeSum = new float[this.coe.length];
            recorrP = p.coe.length - 1;
            for (recorrCoe = this.coe.length - 1; recorrCoe >= 0; recorrCoe--, recorrP--) {
                if (recorrP < 0) {
                    break;
                }
                NewCoeSum[recorrCoe] = p.coe[recorrP] + this.coe[recorrCoe];
            }
            for (int acabarP = recorrCoe; acabarP >= 0; acabarP--) {
                NewCoeSum[acabarP] = this.coe[acabarP];
            }
        }
        Polynomial resultatSum = new Polynomial(NewCoeSum);

        return resultatSum;
    }

    // Multiplica el polinomi amb un altre. No modifica el polinomi actual (this). Genera un de nou
    public Polynomial mult(Polynomial p2) {

        float[] NewCoeMul;
        int dimArray = (this.coe.length + p2.coe.length) - 1;
        int sumaExpCoe = this.coe.length - 1;
        int sumaExpP;
        float sumCoe = 0;

        NewCoeMul = new float[dimArray];

        for (int mulPrimer = 0; mulPrimer < this.coe.length; mulPrimer++, sumaExpCoe--) {
            if (this.coe[mulPrimer] == 0) {
                continue;
            }
            sumaExpP = p2.coe.length - 1;
            for (int mulSegon = 0; mulSegon < p2.coe.length; mulSegon++, sumaExpP--) {
                float resultatMulFloat = this.coe[mulPrimer] * p2.coe[mulSegon];
                int actualGrauMul = sumaExpCoe + sumaExpP;
                if (NewCoeMul[actualGrauMul] != 0 && resultatMulFloat == 0) {
                    continue;
                }
                if (NewCoeMul[actualGrauMul] != 0) {
                    NewCoeMul[actualGrauMul] = sumCoe + resultatMulFloat;
                } else {
                    NewCoeMul[actualGrauMul] = resultatMulFloat;
                }
                sumCoe = NewCoeMul[actualGrauMul];
            }
        }

        ordenarArray(NewCoeMul);

        Polynomial resultatMul = new Polynomial(NewCoeMul);

        return resultatMul;
    }

    // Divideix el polinomi amb un altre. No modifica el polinomi actual (this). Genera un de nou
    // Torna el quocient i també el residu (ambdós polinomis)
    public Polynomial[] div(Polynomial p2) {
        return null;
    }

    // Troba les arrels del polinomi, ordenades de menor a major
    public float[] roots() {
        return null;
    }

    // Torna "true" si els polinomis són iguals. Això és un override d'un mètode de la classe Object
    @Override
    public boolean equals(Object o) {
        Polynomial p = (Polynomial) o;
        // comparar p.coe con this.coe

        if (p == null) {
            return false;
        }
        return true;
    }

    // Torna la representació en forma de String del polinomi. Override d'un mètode de la classe Object
    @Override
    public String toString() {
        String cadena = "";
        //El major grau dels coeficients sempre serà el tamany del array - 1
        int grado = coe.length - 1;
        int activador = 0;

        //Si en el array nomès hi ha un 0, doncs el resultat en string serà 0
        if (this.coe[0] == 0) {
            return cadena + 0;
        }

        //Si no es 0, farem un for per transformar cada numero de l'array coe en un string
        for (int i = 0; i < this.coe.length; i++, grado--, activador++) {
            float actual = this.coe[i];
            int actualRes = (int) actual;


            //Aconseguir el signe del coeficient i llevar-li el signe
            String signo = Float.toString(actual);
            String sinSimbolos = Float.toString(actual);

            //Si el signe es negatiu procedim a llevar-ho
            if (signo.contains("-")) {
                signo = "-"; // Guardem el signe a la variable "signo"

                //si conte el signe "-" el llevam
                sinSimbolos = sinSimbolos.replaceAll("-", "");
                float depas = Float.parseFloat(sinSimbolos);
                int casiActualRes = (int) depas;
                actualRes = casiActualRes;
            } else {
                signo = "+";
            }

            //Si hi ha un 0, no el posam al string
            if (actualRes == 0) {
                continue;
            }

            //Si es mes gran que grau 1 posarem en la estructura ^
            if (grado > 1) {
                if (activador == 0 && actualRes == 1) {
                    if (signo.equals("-")) {
                        cadena = cadena + signo + "x" + "^" + grado + " ";
                    } else {
                        cadena = cadena + "x" + "^" + grado + " ";
                    }
                } else if (activador == 0 && actualRes != 1) {
                    if (signo.equals("-")) {
                        cadena = cadena + signo + actualRes + "x" + "^" + grado + " ";
                    } else {
                        cadena = cadena + actualRes + "x" + "^" + grado + " ";
                    }
                } else if (activador != 0 && actualRes == 1) {
                    cadena = cadena + signo + " " + "x" + "^" + grado + " ";
                } else if (activador != 0 && actualRes != 1) {
                    cadena = cadena + signo + " " + actualRes + "x" + "^" + grado + " ";
                }
            }

            //Si grau 1, posarem una x
            if (grado == 1) {
                if (activador == 0 && actualRes == 1) {
                    if (signo.equals("-")) {
                        cadena = cadena + signo + "x" + " ";
                    } else {
                        cadena = cadena + "x" + " ";
                    }
                } else if (activador == 0 && actualRes != 1) {
                    if (signo.equals("-")) {
                        cadena = cadena + signo + " " + actualRes + "x" + " ";
                    } else {
                        cadena = cadena + actualRes + "x" + " ";
                    }
                } else if (activador != 0 && actualRes == 1) {
                    cadena = cadena + "x" + " ";
                } else if (activador != 0 && actualRes != 1) {
                    cadena = cadena + signo + " " + actualRes + "x" + " ";
                }
            }

            //Si es 0 posarem nomes el numero
            if (grado == 0) {
                cadena = cadena + signo + " " + actualRes;
            }
        }

        //Si nomes hi un monomi, llevarem el espai que ens crea per defecte el to string
        int quantesX = cadena.replaceAll("[^x]", "").length();
        int quantsEspais = cadena.replaceAll("[^ ]", "").length();

        //Nomes es llevara quan hagui una x o ninguna o hagui només el espai a llevar
        if (quantesX <= 1 && quantsEspais <= 1) {
            cadena = cadena.replaceAll(" ", "");
        }

        return cadena;
    }
}


