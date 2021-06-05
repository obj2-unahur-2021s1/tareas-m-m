package ar.edu.unahur.obj2.tareas

import io.kotest.assertions.throwables.shouldThrowAny
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.doubles.plusOrMinus
import io.kotest.matchers.shouldBe

class TareaTest : DescribeSpec({
  describe("Tarea") {

    val empleado1 = Trabajador(400)
    val empleado2 = Trabajador(400)
    val responsable1 = Trabajador(600)

    var tarea1 = Tarea(24.5, 25099.99, responsable1)

    tarea1.asignarEmpleado(empleado1)
    tarea1.asignarEmpleado(empleado2)

    it("Consultar nómina de una tarea") {
      tarea1.nominaDeEmpleados().shouldBe(kotlin.Unit)    // revisar esto, porque es una salida de
                                                          // tipo String y no permite corroborar la
                                                          // lista. El enunciado no especifica cómo
                                                          // es la consulta.
    }

    it("4.25 horas necesarias para finalizar la tarea") {
      tarea1.horasNecesarias().shouldBe(12.25)
    }

    it("44699.99 es el costo de una tarea") {
      tarea1.costoTarea().shouldBe(44699.99 plusOrMinus 0.01)
    }

  }
})
