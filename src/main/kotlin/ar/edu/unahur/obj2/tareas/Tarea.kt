package ar.edu.unahur.obj2.tareas

import kotlin.math.roundToInt

abstract class  Tarea (val  responsable :  Trabajador) {
    abstract fun  nominaDeEmpleados ()
    abstract fun  horasNecesarias(): Double
    abstract fun  costoTarea (): Double
}

class TareaSimple( val horasEstimadas :  Double, val costoInfraestructura :  Double, responsable :  Trabajador): Tarea (responsable) {

    val empleadosAsignados = mutableListOf < Trabajador > ()     // ver si se puede pasar por parámetro

    override fun nominaDeEmpleados() {
        println ( " Nómina de empleados: " )
        empleadosAsignados.forEach {
            println (it)
        }
        println ( " Responsable: "  + responsable)
    }

    override fun horasNecesarias() = horasEstimadas / this.cantidadDeEmpleados()

    override fun costoTarea() =  horasNecesarias() * sueldoPromedioPorHora() + horasEstimadas * responsable.cuantoCobraPorHora + costoInfraestructura

    fun  cantidadDeEmpleados () = empleadosAsignados.size

    fun  asignarEmpleado ( nuevoEmpleado :  Trabajador ) {
        empleadosAsignados.add (nuevoEmpleado)
    }

    fun  sueldoPromedioPorHora (): Double {
        var sumatoria :  Double  =  0.0
        empleadosAsignados.forEach {sumatoria += it.cuantoCobraPorHora}
        return (sumatoria / cantidadDeEmpleados ())
    }
}

class TareaIntegracion( responsable :  Trabajador): Tarea( responsable){

    val tareasDentro = mutableListOf < Tarea>()

    override fun nominaDeEmpleados() = tareasDentro.forEach { it.nominaDeEmpleados() }

    override fun horasNecesarias() = tareasDentro.sumByDouble { it.horasNecesarias() } + this.adicionPorCantidadDeTareas()

    override fun costoTarea() = this.sumaTotalDeCostos() + (this.sumaTotalDeCostos() * 0.03)

    // redondeo primero a int para tener una division exacta y despues a double para que trabaje con double
    fun adicionPorCantidadDeTareas() = ((this.sumaTotalHoras() / 8).roundToInt()).toDouble()

    fun sumaTotalHoras() = tareasDentro.sumByDouble { it.horasNecesarias() }

    fun sumaTotalDeCostos() = tareasDentro.sumByDouble{ it.costoTarea()}

    fun agregarTarea(tareaAAgregar: Tarea) = tareasDentro.add(tareaAAgregar)
}

class  Trabajador (var cuantoCobraPorHora :  Double)


