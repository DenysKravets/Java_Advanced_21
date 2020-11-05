<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <!-- Brand -->
  <a class="navbar-brand" href="#">Logo</a>

  <!-- Links -->
  <ul class="navbar-nav">
  	<li class="nav-item">
      <a class="nav-link" href="${contextPath}/">Main</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="${contextPath}/periodical">Add periodical</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="${contextPath}/showPeriodicals">Periodicals</a>
    </li>

    <!-- Dropdown -->
    <li class="nav-item dropdown">
      <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
        Dropdown link
      </a>
      <div class="dropdown-menu">
        <a class="dropdown-item" href="${contextPath}/">Link 1</a>
        <a class="dropdown-item" href="${contextPath}/">Link 2</a>
        <a class="dropdown-item" href="${contextPath}/">Link 3</a>
      </div>
    </li>
  </ul>
</nav>
