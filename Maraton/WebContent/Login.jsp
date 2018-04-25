<!doctype html>
<html lang="es">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="https://www.marathonpetroleum.com/content/documents/logos/Mlogo_600_px_width.jpg">
	
    <title>LogIn</title>

    <!-- Bootstrap core CSS -->
    <link href="csssignin.css" rel="stylesheet">

  </head> 

  <body class="text-center">
  <div align="center" class = table-bordered>

<form class="form-signin" action="LoginServlet" method="post">
      <img class="mb-4" src="http://www.clker.com/cliparts/W/B/A/i/p/J/boy-and-girl-running.svg" alt="" width="72" height="72">
      <h1 class="h3 mb-3 font-weight-normal">Por favor, inicie sesión</h1>

     <label for="text" class="sr-only">D.N.I.</label>
     <input type="text" id="dni" class="form-control" placeholder="D.N.I. sin letra" required autofocus>
     
     <label for="inputPassword" class="sr-only">Contraseña</label>
      <input type="password" id="password" class="form-control" placeholder="Contraseña" required autofocus>
<br></br>
      <button class="btn btn-lg btn-primary btn-block" type="submit" name="button" id="button" value="Enviar">Registrarse</button>
      <p class="mt-5 mb-3 text-muted">&copy; 2018</p>
      
</form>
</div>
</body>
</html>