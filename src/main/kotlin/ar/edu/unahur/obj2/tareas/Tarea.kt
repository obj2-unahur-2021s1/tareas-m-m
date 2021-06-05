package ar.edu.unahur.obj2.tareas

abstract class  Tarea ( val  horasEstimadas :  Double , val  costoInfraestructura :  Double , val  responsable :  Trabajador ) {

    val empleadosAsignados = mutableListOf < Trabajador > ()     // ver si se puede pasar por parámetro

    fun  sueldoPromedioPorHora (): Double {
        var sumatoria :  Double  =  0.0
        empleadosAsignados.forEach {sumatoria += it.cuantoCobraPorHora}
        return (sumatoria / cantidadDeEmpleados ())
    }
    //problema aca
    fun  nominaDeEmpleados () {
        println ( " Nómina de empleados: " )
        empleadosAsignados.forEach {
            //no entiendo lo de es, lo puse entre comillas porq si lo dejo solo marca error
            println (it)
            //println (es)
        }
        println ( " Responsable: "  + responsable)
    }
    //problema por si alguien quiere agregar un responsable
    fun  asignarEmpleado ( nuevoEmpleado :  Trabajador ) {
        empleadosAsignados.add (nuevoEmpleado)
    }

    fun  cantidadDeEmpleados () = empleadosAsignados.size

    abstract fun  horasNecesarias(): Double

    abstract fun  costoTarea (): Double
}

class TareaSimple(  horasEstimadas :  Double , costoInfraestructura :  Double , responsable :  Trabajador): Tarea (horasEstimadas,costoInfraestructura,responsable) {
    override fun horasNecesarias() = horasEstimadas / this.cantidadDeEmpleados()
    override fun costoTarea() =  horasNecesarias() * sueldoPromedioPorHora() + horasEstimadas * responsable.cuantoCobraPorHora + costoInfraestructura

}

class TareaCompuesta(  horasEstimadas :  Double ,   costoInfraestructura :  Double ,   responsable :  Trabajador): Tarea(horasEstimadas,costoInfraestructura, responsable){
    val tareasDentro = mutableListOf < Tarea >()
    override fun horasNecesarias() = tareasDentro.sumByDouble { it.horasNecesarias() } + this.adicionPorCantidadDeTareas()
    override fun costoTarea() = this.sumaTotalDeCostos() + (this.sumaTotalDeCostos() * 0.03)

    fun cantidadDeSubtareas() = tareasDentro.size

    fun adicionPorCantidadDeTareas() = (this.cantidadDeSubtareas()/8).toInt()

    fun sumaTotalDeCostos() = tareasDentro.sumByDouble { it.costoTarea() }

    fun agregarTarea(tareaAAgregar: Tarea) = tareasDentro.add(tareaAAgregar)
}
// solucionar lo del q esta a acargo
class  Trabajador ( var  cuantoCobraPorHora :  Int ){}