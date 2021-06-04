package ar.edu.unahur.obj2.tareas

class Tarea(var horasEstimadas: Double){
    val empleadosAsignados = mutableListOf<Trabajador>()
    var responsable : Responsable ? = null

    var yaSeAsignoAUnResponsabe = responsable != null

    // fun nominaDeEmpleados() = empleadosAsignados.size
    // me parece que consultar sería mostrar la lista de empleados y mostrar
    // al responsable.

    fun nominaDeEmpleados() {
        println("Nómina de empleados:")
        empleadosAsignados.forEach {
            println(it)
        }
        when(yaSeAsignoAUnResponsabe) {
            true -> println("Responsable de la tarea: " + responsable)
            else -> println("No hay un responsable asignado aún")
        }
    }


    //deberia ser asi
    //fun nominaDeEmpleados() = empleadosAsignados
    fun asignarTrabajador(trabajadorAAgregar: Trabajador){
        if(trabajadorAAgregar.sirveParaHacerLaTarea()){
            empleadosAsignados.add(trabajadorAAgregar)
        }
        else if(!trabajadorAAgregar.sirveParaHacerLaTarea() and !yaSeAsignoAUnResponsabe){
            empleadosAsignados.add(trabajadorAAgregar)
            yaSeAsignoAUnResponsabe = true
        }

    }

    fun asignarResponsable(responsableDeTarea: Responsable) {
        responsable = responsableDeTarea
    }

    fun cantidadDeEmpleados() = empleadosAsignados.size
    //el -1 porq el supervisor no hace nada
    fun horasNecesarias() = horasEstimadas / this.cantidadDeEmpleados() - 1
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
