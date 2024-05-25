import { Component, OnInit } from '@angular/core';
import { UserService } from '../../services/user.service';
import { User } from '../../models/user';
import { Profile } from '../../models/profile';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user-form',
  templateUrl: './user-form.component.html',
  styleUrls: ['./user-form.component.scss']
})
export class UserFormComponent implements OnInit {
  user: User = new User();
  profile: Profile = new Profile();

  constructor(private userService: UserService, private router: Router) { }

  ngOnInit(): void {
  }

  saveUser() {
    this.user.profile = this.profile;
    this.userService.createUser(this.user).subscribe(() => {
      this.router.navigate(['/users']);
    });
  }
}
