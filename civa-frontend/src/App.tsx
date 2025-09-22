import React, { useEffect, useState } from "react";
import "./index.css";

interface Marca {
  id: number;
  name: string;
}

interface Bus {
  id: number;
  numeroBus: string;
  placa: string;
  fechaCreacion: string;
  caracteristicas: string;
  marca: Marca;
  activo: boolean;
}

interface PageResponse {
  content: Bus[];
  totalPages: number;
}

function App() {
  const [buses, setBuses] = useState<Bus[]>([]);
  const [loading, setLoading] = useState<boolean>(true);
  const [page, setPage] = useState<number>(0);
  const [size] = useState<number>(5);
  const [totalPages, setTotalPages] = useState<number>(0);

  const [searchId, setSearchId] = useState<string>("");
  const [busById, setBusById] = useState<Bus | null>(null);

  useEffect(() => {
    fetch(`http://localhost:8080/api/buses?page=${page}&size=${size}`)
      .then((response) => response.json())
      .then((data: PageResponse) => {
        setBuses(data.content);
        setTotalPages(data.totalPages);
        setLoading(false);
      })
      .catch((error) => {
        console.error("Error al obtener buses:", error);
        setLoading(false);
      });
  }, [page, size]);

  const handleSearch = () => {
    if (!searchId) return;
    fetch(`http://localhost:8080/api/buses/${searchId}`)
      .then((res) => {
        if (!res.ok) throw new Error("No se encontró el bus");
        return res.json();
      })
      .then((data: Bus) => {
        setBusById(data);
        alert(
          `Bus encontrado:\nID: ${data.id}\nNúmero: ${data.numeroBus}\nPlaca: ${data.placa}\nMarca: ${data.marca.name}`
        );
        setSearchId("");
      })
      .catch((err) => {
        alert(err.message);
      });
  };

  if (loading) return <h2 className="loading">Cargando...</h2>;

  return (
    <div className="container">
      <h1 className="title">Lista de Buses</h1>

      <div className="search-box">
        <input
          type="number"
          placeholder="Buscar por ID"
          value={searchId}
          onChange={(e) => setSearchId(e.target.value)}
        />
        <button onClick={handleSearch}>Buscar</button>
      </div>

      <table className="bus-table">
        <thead>
          <tr>
            <th>ID</th>
            <th>Número de Bus</th>
            <th>Placa</th>
            <th>Marca</th>
            <th>Características</th>
            <th>Activo</th>
          </tr>
        </thead>
        <tbody>
          {buses.length === 0 ? (
            <tr>
              <td colSpan={6}>No hay buses registrados</td>
            </tr>
          ) : (
            buses.map((bus) => (
              <tr key={bus.id}>
                <td>{bus.id}</td>
                <td>{bus.numeroBus}</td>
                <td>{bus.placa}</td>
                <td>{bus.marca?.name}</td>
                <td>{bus.caracteristicas}</td>
                <td>{bus.activo ? "✅" : "❌"}</td>
              </tr>
            ))
          )}
        </tbody>
      </table>

      <div className="pagination">
        <button
          onClick={() => setPage((p) => Math.max(p - 1, 0))}
          disabled={page === 0}
        >
          ⬅ Anterior
        </button>
        <span>
          Página <b>{page + 1}</b> de <b>{totalPages}</b>
        </span>
        <button
          onClick={() => setPage((p) => Math.min(p + 1, totalPages - 1))}
          disabled={page === totalPages - 1}
        >
          Siguiente ➡
        </button>
      </div>
    </div>
  );
}

export default App;
