package ar.edu.unahur.obj2.tareas

class Tarea(var horasEstimadas: Double){
    val trabajadoresEnLaTarea = mutableListOf<Trabajador>()
    var responsable : Responsable ? = null

    var yaSeAsignoAUnResponsabe = responsable != null

    // fun nominaDeEmpleados() = trabajadoresEnLaTarea.size
    // me parece que consultar sería mostrar la lista de empleados y mostrar
    // al responsable.
    fun nominaDeEmpleados() {
        println("Nómina de empleados:")
        trabajadoresEnLaTarea.forEach {
            println(it)
        }
        when(yaSeAsignoAUnResponsabe) {
            true -> println("Responsable de la tarea: " + responsable)
            else -> println("No hay un responsable asignado aún")
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

    fun asignarResponsable(responsableDeTarea: Responsable) {
        responsable = responsableDeTarea
    }

    fun cantidadDeEmpleados() = trabajadoresEnLaTarea.size

    fun horasNecesarias() = horasEstimadas / this.cantidadDeEmpleados()
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
