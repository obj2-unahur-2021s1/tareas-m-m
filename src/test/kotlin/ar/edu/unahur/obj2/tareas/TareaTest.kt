package ar.edu.unahur.obj2.tareas

import io.kotest.assertions.throwables.shouldThrowAny
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class TareaTest : DescribeSpec({
  describe("Tarea") {
    var tarea1 = Tarea(8.5)
    val empleado1 = Empleado(400)
    val empleado2 = Empleado(400)
    val responsable1 = Responsable(600)

    tarea1.asignarTrabajador(empleado1)
    tarea1.asignarTrabajador(empleado2)

    it("Consultar nómina de una tarea") {
      tarea1.nominaDeEmpleados().shouldBe(kotlin.Unit)    // revisar esto, porque es una salida de
                                                          // tipo String y no permite corroborar la
                                                          // lista. El enunciado no especifica cómo
                                                          // es la consulta.
    }

    it("Consultar nómina con un responsable") {
      tarea1.asignarResponsable(responsable1)
      tarea1.nominaDeEmpleados().shouldBe(kotlin.Unit)    // idem - después de saber cómo es la
                                                          // consulta, se pueden aprovechar estos
                                                          // dos test distintos.
    }

    it("4.25 horas necesarias para finalizar la tarea") {
      tarea1.horasNecesarias().shouldBe(4.25)
    }
  }
})
