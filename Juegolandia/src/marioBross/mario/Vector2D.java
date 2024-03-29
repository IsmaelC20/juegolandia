
// Vector2D.java -----------------------------------------------------
// TODO Traducir todos los comentarios al ingl�s!!!

package marioBross.mario;


/**
 * Representa un vector matem�tico sobre los ejes X e Y (2
 * dimensiones). Es de gran utilidad para representar el vector
 * velocidad de objetos o personajes en toda clase de juegos.
 * Hay que tener en cuenta la diferencia que existe entre los
 * ejes matem�ticos y los ejes gr�ficos de la pantalla. El eje X
 * es igual para los dos, pero, en el eje Y hay diferencias.
 * En el caso matem�tico el eje Y aumenta conforme subimos en la
 * gr�fica, es decir todo lo contrario a el eje gr�fico de la
 * pantalla. El Vector2D utiliza un eje matem�tico.</ br>
 * Por ejemplo, un vector con las coordenadas (2,3) se encuentra en
 * el 1� cuadrante, por lo que deber�a ir arriba a la derecha,
 * pero sobre la pantalla ese vector se encuentra en el 4� cuadrante,
 * abajo a la izquierda.
 */
public class Vector2D {

	// Vector properties
	protected double x, y, module, angle;

	/**
	 * Defauld constructor that init all the
	 * properties to 0.</ br>
	 * Module = 0;</ br>
	 * Angle = 0;</ br>
	 * X = 0;</ br>
	 * Y = 0;</ br>
	 */
	public Vector2D() {
		this(0, 0);
	}

	/**
	 * Vector2D with the specificated module.</ br>
	 * Angulo = 0;</ br>
	 * X = module;</ br>
	 * Y = 0;</ br>
	 */
	public Vector2D(double module) {
		this(module, 0);
	}

	/**
	 * Vector2D with the specificated module and angle.
	 * Las coordenadas son obtenidas por trigonometr�a.</ br>
	 * X = cos(�ngulo)*m�dulo;</ br>
	 * Y = sen(�ngulo)*m�dulo;</ br>
	 */
	public Vector2D(double module, double angle) {
		this.setModule(module);
		this.setAngle(angle);
	}

	/**
	 * Crea un nuevo Vector2D a partir de uno ya existente. Se puede
	 * decir que crea una copia de �ste.
	 */
	public Vector2D(Vector2D vector) {
		this.module = vector.getModule();
		this.angle = vector.getAngle();
		this.x = vector.getAccurateX();
		this.y = vector.getAccurateY();
	}


	// SET methods --------------------------------------------------
	public void setModule(double module) {
		this.module = module;
		updateXY();
	}

	/**
	 * Cambia el �ngulo del vector y actualiza las coordenadas para
	 * que el m�dulo siga siendo el mismo.
	 *
	 * @param angle El �ngulo en radianes
	 */
	public void setAngle(double angle) {
		this.angle = angle % (2*Math.PI);
		if (this.angle > Math.PI) {
			this.angle = -angle % Math.PI;
		} else if (this.angle < -Math.PI) {
			this.angle = 2*Math.PI+angle;
		} else if (this.angle < 0) {
			this.angle = angle % Math.PI;
		}
		updateXY();
	}

	/**
	 * Cambia el �ngulo utilizando grados.
	 *
	 * @param angle El �ngulo en grados.
	 */
	public void setAngle(int angle) {
		this.setAngle(Math.toRadians(angle));
	}

	public void setX(double x) {
		this.x = x;
		updateModule();
		updateAngle();
	}

	public void setY(double y) {
		this.y = y;
		updateModule();
		updateAngle();
	}
	//  end of SET methods ------------------------------------------


	// GET methods --------------------------------------------------
	public int getX() {
		return ((int)x);
	}

	public int getY() {
		return ((int)y);
	}

	public double getAccurateX() {
		