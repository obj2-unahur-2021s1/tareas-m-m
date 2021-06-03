package ar.edu.unahur.obj2.tareas

class Tarea(var horasEstimadas: Double){
    val trabajadoresEnLaTarea = mutableListOf<Trabajador>()
    // var responsable : Responsable =

    var yaSeAsignoAUnResponsabe = false

    // fun nominaDeEmpleados() = trabajadoresEnLaTarea.size
    // me parece que consultar sería mostrar la lista de empleados y mostrar
    // al responsable.
    fun nominaDeEmpleados() {
        trabajadoresEnLaTarea.forEach {
            println(it)
        }
    }

    fun agregarUnTrabajador(trabajadorAAgregar: Trabajador){
        if(trabajadorAAgregar.sirveParaHacerLaTarea()){
            trabajadoresEnLaTarea.add(trabajadorAAgregar)
        }
        else if(!trabajadorAAgregar.sirveParaHacerLaTarea() and !yaSeAsignoAUnResponsabe){
            trabajadoresEnLaTarea.add(trabajadorAAgregar)
            yaSeAsignoAUnResponsabe = true
        }

    }
/*
    fun asignarResponsable(responsableDeTarea: Responsable) {
        responsable = responsableDeTarea
    }
*/
    fun cantidadDeEmpleados() = trabajadoresEnLaTarea.size

    fun tiempoRequeridoParaHacerLaTarea() = horasEstimadas/ this.cantidadDeEmpleados() -1
}



//pensando seriamente en que deberia ser inteface
abstract class Trabajador(var cuantoCobraPorHora: Int){
    abstract fun sirveParaHacerLaTarea(): Boolean
}
class Empleado(cuantoCobraPorHora: Int): Trabajador(cuantoCobraPorHora) {
    override fun sirveParaHacerLaTarea() = true
}
class Responsable(cuantoCobraPorHora: Int): Trabajador(cuantoCobraPorHora){
    override fun sirveParaHacerLaTarea() = false
}
