window.addEventListener('load', function () {

    //Buscamos y obtenemos el formulario donde estan
    //los datos que el usuario pudo haber modificado del estudiante
    const formulario = document.querySelector('#update_dentist_form');
    formulario.addEventListener('submit', function (event) {

        let dentistId = document.querySelector('#dentist_id').value;

        //creamos un JSON que tendrá los datos del estudiante
        //a diferencia de un estudiante nuevo en este caso enviamos el id
        //para poder identificarlo y modificarlo para no cargarlo como nuevo

                const street = document.querySelector('#street').value
                const number = document.querySelector('#number').value
                const city = document.querySelector('#city').value

                const formData = {
                   id: document.querySelector('#dentist_id').value,
                   name: document.querySelector('#nombre').value,
                   lastname: document.querySelector('#apellido').value,
                   email: document.querySelector('#email').value,
                   dni: document.querySelector('#dni').value,
                   initDate: document.querySelector('#initDate').value,
                   address: {
                   street: street,
                   number: number,
                   city: city
                   }
                   };

        //invocamos utilizando la función fetch la API estudiantes con el método PUT
        //que modificará al estudiante que enviaremos en formato JSON
        const url = '/patients/update';
        const settings = {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formData)
        }
          fetch(url,settings)
          .then(response => response.json())

    })
 })

    //Es la funcion que se invoca cuando se hace click sobre el id de un estudiante del listado
    //se encarga de llenar el formulario con los datos del estudiante
    //que se desea modificar
    function findBy(id) {
          const url = '/patients'+"/"+id;
          const settings = {
              method: 'GET'
          }
          fetch(url,settings)
          .then(response => response.json())
          .then(data => {
          console.log(data)
              let patient = data;
              document.querySelector('#dentist_id').value = patient.id;
              document.querySelector('#nombre').value = patient.name;
              document.querySelector('#apellido').value = patient.lastname;
              document.querySelector('#email').value = patient.email;
              document.querySelector('#dni').value = patient.dni;
              document.querySelector('#initDate').value = patient.initDate;

              document.querySelector('#street').value = patient.address.street;
              document.querySelector('#number').value = patient.address.number;
              document.querySelector('#city').value = patient.address.city;

            //el formulario por default esta oculto y al editar se habilita
              document.querySelector('#div_dentist_updating').style.display = "block";
          }).catch(error => {
              console.log(error)
          })
      }