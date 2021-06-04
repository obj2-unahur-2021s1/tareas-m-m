package ar.edu.unahur.obj2.tareas

class Tarea(val horasEstimadas: Double, val costoInfraestructura: Double) {

    val empleadosAsignados = mutableListOf<Trabajador>()    // ver si se puede pasar por parámetro
    // var yaSeAsignoAUnResponsabe = responsable != null

    // esta función debería ser el promedio (si entendí bien) de los sueldos de todos los empleados
    // si es así, entonces habría que recorrer la lista de empleados, sumar sus sueldos y dividirlos
    // por la cantidad total de empleados.
    fun sueldoPorHora() = 400.99 // pongo este valor de manera temporal para que funcione costoTarea
                               // pero hay que modificar la función.

    // fun nominaDeEmpleados() = empleadosAsignados.size
    // me parece que consultar sería mostrar la lista de empleados y mostrar
    // al responsable.
    fun nominaDeEmpleados() {
        println("Nómina de empleados:")
        empleadosAsignados.forEach {
            println(it)
        }
        /*
        when(yaSeAsignoAUnResponsabe) {
            true -> println("Responsable de la tarea: " + responsable)
            else -> println("No hay un responsable asignado aún")
        }
        */
    }

    // ver si se puede pasar directamente la lista por parámetro al objeto
    /*
    fun asignarTrabajador(trabajadorAAgregar: Trabajador){
        if(trabajadorAAgregar.sirveParaHacerLaTarea()){
            empleadosAsignados.add(trabajadorAAgregar)
        }
        else if(!trabajadorAAgregar.sirveParaHacerLaTarea() and !yaSeAsignoAUnResponsabe){
            empleadosAsignados.add(trabajadorAAgregar)
            yaSeAsignoAUnResponsabe = true
        }

    }
    */

    fun asignarTrabajador(nuevoEmpleado: Trabajador) {
        empleadosAsignados.add(nuevoEmpleado)
    }

    fun cantidadDeEmpleados() = empleadosAsignados.size -1

    fun horasNecesarias() = horasEstimadas / this.cantidadDeEmpleados()

    fun costoTarea() = horasNecesarias() * sueldoPorHora() + horasEstimadas * responsable.cuantoCobraPorHora + costoInfraestructura
}


// No entiendo por qué le pusiste la función sirveParaHacerLaTarea()... no está en la consigna y
// complica el código.
// ahí propongo alternativa

//pensando seriamente en que deberia ser inteface
abstract class Trabajador(var cuantoCobraPorHora: Int){
    // abstract fun sirveParaHacerLaTarea(): Boolean
    abstract fun esResponsable() : Boolean
}
class Empleado(cuantoCobraPorHora: Int): Trabajador(cuantoCobraPorHora) {
    //     override fun sirveParaHacerLaTarea() = true
    override fun esResponsable() = false
}
class Responsable(cuantoCobraPorHora: Int): Trabajador(cuantoCobraPorHora){
    // override fun sirveParaHacerLaTarea() = false
    override fun esResponsable() = true
}
