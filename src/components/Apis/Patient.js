import React, { Component } from 'react';
import axios from "axios";
import "bootstrap/dist/css/bootstrap.min.css";
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faEdit, faTrashAlt } from '@fortawesome/free-solid-svg-icons';
import { Modal, ModalBody, ModalFooter, ModalHeader } from 'reactstrap';
import "./Home.css";

const urlTodos="http://localhost:8080/patients/lists";
const urlPost="http://localhost:8080/patients/register";
const urlDelete="http://localhost:8080/patients/";
const urlPut="http://localhost:8080/patients/update";


class Patient extends Component {
state={
  data:[],
  modalInsertar: false,
  modalEliminar: false,
  form:{
    id: '',
    name: '',
    lastname: '',
    email: '',
    dni:'',
    initDate:'',
    address:{
      id:'',
      street:'',
      number:'',
      city:''
    },
    tipoModal: ''
  },
}

peticionGet=()=>{
axios.get(urlTodos).then(response=>{
   console.log(response)
  this.setState({data: response.data});
}).catch(error=>{
  console.log(error.message);
})
}

peticionPost=async()=>{
  delete this.state.form.id;
 await axios.post(urlPost,this.state.form).then(response=>{
    this.modalInsertar();
    this.peticionGet();
  }).catch(error=>{
    console.log(error.message);
  })
}

peticionPut=()=>{
  axios.put(urlPut, this.state.form).then(response=>{
    this.modalInsertar();
    this.peticionGet();
  })
}

peticionDelete=()=>{
  axios.delete(urlDelete+this.state.form.id).then(response=>{
    this.setState({modalEliminar: false});
    this.peticionGet();
  })
}

modalInsertar=()=>{
  this.setState({modalInsertar: !this.state.modalInsertar});
}

seleccionarCliente=(data)=>{
  this.setState({
    tipoModal: 'actualizar',
    form: {
      id: data.id,
      lastname: data.lastname,
      email: data.email,
      dni : data.dni,
      initDate: data.initDate,
      address: {
        street: data.street,
        number: data.number,
        city: data.city
      }
    }
  })
}

handleChange=async e=>{
e.persist();
await this.setState({
  form:{
    ...this.state.form,
    [e.target.name]: e.target.value
  }
});
console.log(this.state.form.address);
}

  componentDidMount() {
    this.peticionGet();
  }
  

  render(){
    const {form}=this.state;
  return (
    <div className="App" id="home">
    <br /><br /><br />
  <button className="btn btn-success" id="btn" onClick={()=>{this.setState({form: null, tipoModal: 'insertar'}); this.modalInsertar()}}>Add Patient</button>
  <br /><br />
    <table className="table" id="tablev2">
      <thead>
        <tr>
          <th>ID</th>
          <th>Name</th>
          <th>Lastname</th>
          <th>Email</th>
          <th>Dni</th>
          <th>Init Date</th>
        </tr>
      </thead>
      <tbody>
          
        {this.state.data.map((data,i)=>{
          return(
            <tr key={i}>
          <td>{data.id}</td>
          <td>{data.name}</td>
          <td>{data.lastname}</td>
          <td>{data.email}</td>
          <td>{data.dni}</td>
          <td>{data.initDate}</td>
          <td>{data.street}</td>
          <td>{data.number}</td>
          <td>{data.city}</td>
          <td>
                <button className="btn btn-primary" id="btn"  onClick={()=>{this.seleccionarCliente(data); this.modalInsertar()}}><FontAwesomeIcon icon={faEdit}/></button>
                {"   "}
                <button className="btn btn-danger" onClick={()=>{this.seleccionarCliente(data); this.setState({modalEliminar: true})}}><FontAwesomeIcon icon={faTrashAlt}/></button>
                </td>
          </tr>
          )
        })}
      </tbody>
    </table>



    <Modal isOpen={this.state.modalInsertar}>
                <ModalHeader style={{display: 'block'}}>
                  <span style={{float: 'right'}} onClick={()=>this.modalInsertar()}>x</span>
                </ModalHeader>
                <ModalBody>
                  <div className="form-group">
                    <label htmlFor="id">ID</label>
                    <input className="form-control" type="text" name="id" id="id" readOnly onChange={this.handleChange} value="Default"/>
                    <br />
                    <label htmlFor="nombre">Name</label>
                    <input className="form-control" type="text" name="name" id="name" onChange={this.handleChange} value={form?form.name: ''}/>
                    <br />
                    <label htmlFor="nombre">Lastname</label>
                    <input className="form-control" type="text" name="lastname" id="lastname" onChange={this.handleChange} value={form?form.lastname: ''}/>
                    <br />
                    <label htmlFor="nombre">Email</label>
                    <input className="form-control" type="text" name="email" id="email" onChange={this.handleChange} value={form?form.email: ''}/>
                    <br />
                    <label htmlFor="nombre">Dni</label>
                    <input className="form-control" type="text" name="dni" id="dni" onChange={this.handleChange} value={form?form.dni: ''}/>
                    <br />
                    <label htmlFor="nombre">Init Date</label>
                    <input className="form-control" type="text" name="initDate" id="initDate" placeholder="YYYY-MM-DD" onChange={this.handleChange} value={form?form.initDate: ''}/>
                    <br />
                    <label htmlFor="nombre">Street</label>
                    <input className="form-control" type="text" name="street" id="street" onChange={this.handleChange} value={form?form.street: ''}/>
                    <br />
                    <label htmlFor="nombre">Number</label>
                    <input className="form-control" type="text" name="number" id="number" onChange={this.handleChange} value={ form?form.number: ''}/>
                    <br />
                    <label htmlFor="nombre">City</label>
                    <input className="form-control" type="text" name="city" id="city" onChange={this.handleChange} value={form?form.city: ''}/>
                    <br />
                  </div>
                </ModalBody>

                <ModalFooter>
                  {this.state.tipoModal==='insertar'?
                    <button className="btn btn-success" onClick={()=>this.peticionPost()}>
                    Insert
                  </button>: <button className="btn btn-primary" onClick={()=>this.peticionPut()}>
                    Update
                  </button>
  }
                    <button className="btn btn-danger" onClick={()=>this.modalInsertar()}>Cancel</button>
                </ModalFooter>
          </Modal>


          <Modal isOpen={this.state.modalEliminar}>
            <ModalBody>
            Are you sure you want to delete?
            </ModalBody>
            <ModalFooter>
              <button className="btn btn-danger" onClick={()=>this.peticionDelete()}>Yes</button>
              <button className="btn btn-secundary" onClick={()=>this.setState({modalEliminar: false})}>No</button>
            </ModalFooter>
          </Modal>
  </div>
  );
}
}
export default Patient;
