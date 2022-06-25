import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { UsesrServiceService } from '../../../user/services/user-service/usesr-service.service';
import { UserRegister } from '../../../shared/models/usre-register';
import { FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css'],
})
export class RegistrationComponent implements OnInit {
  secondPartQuestions: FormGroup;

  name: string;
  lastName: string;
  email: string;
  password: string;

  constructor(
    private userService: UsesrServiceService,
    private fb: FormBuilder,
    public router: Router
  ) {}

  ngOnInit(): void {
    this.secondPartQuestions = this.fb.group({
      name: new FormControl('', [Validators.required]),
      lastName: new FormControl('', [Validators.required]),
      email: new FormControl('', [Validators.required]),
      password: new FormControl('', [Validators.required]),
    });
  }

  submit(): void {
    var user: UserRegister = {
      lastname: this.lastName,
      name: this.name,
      password: this.password,
      email: this.email,
      username: this.email,
    };
    this.userService.register(user).subscribe((res) => {
      console.log(res, 'ddd');
      if (res !== null) {
        alert('Successfully registered.');
        this.router.navigate(['/login']);
      }
    });
  }
}
