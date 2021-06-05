package ar.edu.unahur.obj2.tareas

abstract class  Tarea ( val  horasEstimadas :  Double , val  costoInfraestructura :  Double , val  responsable :  Trabajador ) {

    val empleadosAsignados = mutableListOf < Trabajador > ()     // ver si se puede pasar por parámetro

    fun  sueldoPromedioPorHora (): Double {
        var sumatoria :  Double  =  0.0
        empleadosAsignados.forEach {sumatoria += it.cuantoCobraPorHora}
        return (sumatoria / cantidadDeEmpleados ())
    }

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

    fun  horasNecesarias () = horasEstimadas /  this .cantidadDeEmpleados ()

    fun  costoTarea () = horasNecesarias () * sueldoPromedioPorHora () + horasEstimadas * responsable.cuantoCobraPorHora + costoInfraestructura
}

class TareaSimple(  horasEstimadas :  Double , costoInfraestructura :  Double , responsable :  Trabajador): Tarea (horasEstimadas,costoInfraestructura,responsable){}
class TareaCompuesta(  horasEstimadas :  Double ,   costoInfraestructura :  Double ,   responsable :  Trabajador): Tarea(horasEstimadas,costoInfraestructura, responsable){
    val tareasDentro = mutableListOf < Tarea >()
}

class  Trabajador ( var  cuantoCobraPorHora :  Int )